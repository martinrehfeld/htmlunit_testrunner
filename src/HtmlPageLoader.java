//
//  HtmlPageLoader.java
//  HtmlPageLoader
//
//  Created by Martin Rehfeld on 15.09.08.
//  Copyright (c) 2008 GL Networks. All rights reserved.
//

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.BrowserVersion;

public class HtmlPageLoader {

  WebClient webClient;
  
  public HtmlPageLoader() {
    webClient = new WebClient();
  }

  public HtmlPageLoader(BrowserVersion version) {
    webClient = new WebClient(version);
  }

  public HtmlPage getPage(String url) throws Exception {
    return (HtmlPage) webClient.getPage(url);
  }

}
