Test structure requirements:
Browser – Chrome
Window – maximized
Web Elements locators should not be autogenerated by browsers plugins
Priority: 
DOM selector
CSS selector
XPATH selector
All code should be separated by functional methods
Functional methods should be parameterized if it is possible
All code should according Java Code Convention
Tests should be run through the Test NG suite xml file.
Should be created maven profiles for hw3
All tests must launch through the maven command

Exercise:
Copy your HW2 ex1 & ex2 test to the proper package
Refactor these tests in Void Page Object design pattern.
Create Page Components (Page Composite) for the page elements
Try to manage correctly the place where you will create a driver instance and where you create an object of your page. 
Parametrize exact methods which you decide should be parametrized.
Do not use hard coded tests data into page objects
User data should be stored in the java properties file

Bonus:
	Implement Fluent Page Object design patter for the any ex from HW2. All previous conditions should be passed.
