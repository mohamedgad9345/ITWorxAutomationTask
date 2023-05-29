$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("ITWorx_Edu_Login.feature");
formatter.feature({
  "line": 1,
  "name": "Super Admin login to the website",
  "description": "",
  "id": "super-admin-login-to-the-website",
  "keyword": "Feature"
});
formatter.scenario({
  "comments": [
    {
      "line": 2,
      "value": "#As a Super Admin, I need to be able to login"
    },
    {
      "line": 4,
      "value": "# Happy Scenario ()"
    }
  ],
  "line": 6,
  "name": "01 - SuperAdmin - login to the WinjiGo website",
  "description": "",
  "id": "super-admin-login-to-the-website;01---superadmin---login-to-the-winjigo-website",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 5,
      "name": "@smoke"
    },
    {
      "line": 5,
      "name": "@regression"
    },
    {
      "line": 5,
      "name": "@hs"
    }
  ]
});
formatter.step({
  "comments": [
    {
      "line": 7,
      "value": "# login with  super admin"
    }
  ],
  "line": 8,
  "name": "the user in the login page",
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "user enter user name and password",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "click on login button",
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "user redirect to the home page",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
});