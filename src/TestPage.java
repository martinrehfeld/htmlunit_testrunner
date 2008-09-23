//
//  TestPage.java
//  TestPage
//
//  Created by Martin Rehfeld on 15.09.08.
//  Copyright (c) 2008 GL Networks. All rights reserved.
//

import java.util.ArrayList;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import org.w3c.dom.NodeList;

public class TestPage {
  HtmlPage testPage;
  
  public TestPage(HtmlPage htmlPage) {
    testPage = htmlPage;
  }
  
  // find all divs with class "logsummary"
  public ArrayList getLogsummaryDivs() {
    final NodeList divs = testPage.getElementsByTagName("div");
    final ArrayList logSummaries = new ArrayList();
    
    for (int i = 0; i < divs.getLength(); i++) {
      final HtmlElement div = (HtmlElement) divs.item(i);
      if (div.getAttribute("class").equals("logsummary")) {
        logSummaries.add(div);
      }
    }
    
    return logSummaries;
  }
  
}
