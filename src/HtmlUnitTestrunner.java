//
//  HtmlUnitTestrunner.java
//  HtmlUnitTestrunner
//
//  Created by Martin Rehfeld on 15.09.08.
//  Copyright (c) 2008 GL Networks. All rights reserved.
//

import java.util.*;
import org.apache.log4j.PropertyConfigurator;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.BrowserVersion;

public class HtmlUnitTestrunner {

  public static void main (String args[]) throws Exception {
    // check command line parameter
    if(args.length != 1) {
      usage("Incorrect number of parameters.");
    }

    setupLog4j();
    
    // load HTML test page and convert into TestPage object
    final HtmlPage htmlPage = new HtmlPageLoader(BrowserVersion.FIREFOX_2).getPage(args[0]);
    final TestPage testPage = new TestPage(htmlPage);
  
    ArrayList logSummaries = testPage.getLogsummaryDivs();
    if (logSummaries.isEmpty()) {
      System.err.println("FATAL: Could not find any logsummary element on page!");
      System.exit(1);
    }

    // TODO: handle multiple logsummaries on one page
    HtmlElement logsummary = (HtmlElement) logSummaries.get(0);
    
    // wait for the test to finish
    while (!logsummary.asText().matches("\\d+ tests, \\d+ assertions, \\d+ failures, \\d+ errors")) {
      Thread.sleep(100);
    } 

    // report result
    System.out.println(logsummary.asText());
    if (logsummary.asText().matches("\\d+ tests, \\d+ assertions, 0 failures, 0 errors")) {
      System.exit(0);
    } else {
      System.exit(1);
    }
  }
  
  private static void setupLog4j() {
    // silence log4j WARN about not being configured properly
    final Properties log4jProperties = new Properties();
    log4jProperties.setProperty("log4j.rootLogger","ERROR, ROOTLOGGER");
    log4jProperties.setProperty("log4j.appender.ROOTLOGGER","org.apache.log4j.ConsoleAppender");
    log4jProperties.setProperty("log4j.appender.ROOTLOGGER.layout","org.apache.log4j.SimpleLayout");
    PropertyConfigurator.configure(log4jProperties);
  }
  
  private static void usage(String errMsg) {
    System.err.println(errMsg);
    System.err.println("\nUsage: HtmlUnitTestrunner " +
           "<URL to unit test>\n"+
      "where  <URL to unit test> references a Javascript unit test page\n"+
      "      (unittest.js / jsunittest.js based).\n");
    System.exit(1);
  }

}
