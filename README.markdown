HtmlUnitTestrunner
==================

HtmlUnitTestrunner is a specialized browser-simulator to be run from the command line. It will specifically run Javascript unit tests based on the unittest.js (Scriptacolous) or jsunittest.js (DrNic) frameworks.

Usage
-----

`HtmlUnitTestrunner <URL to unit test page>`

If you want to run a unit test from your filesystem, just use a file:// URL.

Example Output
--------------

`6 tests, 15 assertions, 0 failures, 0 errors`

The general result will also be communicated via the program exit code (0 = success, 1 = failure).

Background
----------
HtmlUnitTestrunner was created to integrate JS unit tests nicely into cruisecontrol.rb CI builds. It is included in my fork of javascript_test (originally created by Thomas Fuchs).

HtmlUnitTestrunner uses HTMLUnit to simulate a Firefox 2 compatible browser; HTMLUnit in turn uses the Mozilla Rhino Javascript engine.

HtmlUnitTestrunner was tested successfully even on complex JS files including the rather large ExtJS framework, for instance.

License
-------

* HTMLUnit was released under the [Apache 2 License][AP2LIC] and is included with its respective dependencies in the lib folder
* HtmlUnitTestrunner's genuine code (everything that is not in the lib folder) is released under the [MIT License][MITLIC]

[AP2LIC]: http://www.apache.org/licenses/LICENSE-2.0.txt
[MITLIC]: http://www.opensource.org/licenses/mit-license.php
