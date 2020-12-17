# Framework Automation WEB, Mobile, API and DeskTop

@Autor Douglas Gelli

@building June/2020

## 1) Parameters and Execution 

### To parameters access:
- src/main/resources/properties/config.properties

### To Run with JUnit (Not use in Grid)
***Be careful to not execute scenario whit grid tag! it will not works!*** 
- src/test/java/br/com/dgelli/RunnerTest.java

### To Run with TestNG (Optional) (Just Only to use Web and/or API in Grid execution)
***Be careful to not execute scenario whit hooks driver and sequence scenario! it will not works!*** 
**_Configure correctly Class RunnnerTest.java_**
 
- Adding the TestNG Library into the project.
		- Right Click on the Project
		- Build Path
		- Configure Build Path
		- Libraries (Tab)
		- Go to "Add Library" and click the button.
		- Add the 'TestNG' Library and click Ok/Next.
		- TestNG Library will be added to your project.
- Open **_Run Configurations..._** on eclipse
		- double click on TestNG
		- Type **_name_** of project
		- Choose **_project_**
		- Choose **_class_**
		- Run

- Choose parallel execution in
	- src/test/java/br/com/dgelli/RunnerTest.java
	- ***OBS: parallel execution work only API and WEB***

### To Run with Maven (Optional)
- in the project folder by cmd type: mvn test

## 2) Outputs - Reports and Evidences
Evidence and reports will be generated in the output folder located at the root of the project.

### Html Report
- Generate on output/HtmlReport/'sysdate'/Report.html

### Excel Report
- Generate on output/ExcelReport/'sysdate'/report.xlsx

### Cucumber Report and JSon Report
- Generate on output/CucumberReport/

### Word
- Generate on output/Evidence/'sysdate'/'name of case test-Status-date-houer.docx'

### Log
- Generate on output/Log/log.log




# Requirements to Run All project
  
## 1) Must Have JDK installed in Version 8
- Link to download 
https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html
- version used in this building was JDK 8 u 251


## 2) Android studio
### 2.1) Link to download and install:
https://developer.android.com/studio

On Android Studio - Create new project

- Click on: - Configure - SDK management
	- SDK Platforms = Choose the Android to be used
	- SDK Tools
		- Android SDK Build-Tools, 
		- Android Emulator, 
		- Android SDK Platform-Tools, 
		- Android SDK Tools, 
		- Intel X86 Emulator Accelerator, 


- Create environment variables (Item 3)

- In CMD type to verify installation:
	- adb 
	- emulator
	- uiautomatorviewer - optional

### 2.2) Emulator 
- Click in AVD Manager
- Create phone
- Start the phone

### 2.3) Identify the device created or connected:
cmd: emulator -list-avds

### 2.4) Another way to start with less resource (Optional)
- in command prompt:
	- cd %ANDROID_HOME%/emulator
	- emulator @Nexus_5_API_26

### 2.5) Star emulator automatic
in file **StartEmulator.bat**
edit this file with your device

## 3) Environment variables
### Java JDK
- **Create:** JAVA_HOME = C:\Program Files\Java\jdk1.8.0_251
- **Path:** %JAVA_HOME%\bin;

### Android Studio
- **Create:** ANDROID_HOME = %userprofile%\AppData\Local\Android\Sdk
- **Path:** %ANDROID_HOME%\tools;%ANDROID_HOME%\tools\bin;%ANDROID_HOME%\platform-tools;%JAVA_HOME%\bin;

### Maven
- **Create:** M2_HOME = C:\Program Files\apache-maven-3.6.3
- **Path:** %M2_HOME%\bin;


## 4) Appium (Optional)
### 4.1) Download link and install 
This project used the version 1.17.1
https://github.com/appium/appium-desktop/releases

-Start Server

### 4.2) Element capture by Appium
- on custom Server - Desider Capabilities
Ex:
```
{
  "platformName": "Android",
  "deviceName": "0042825151",
  "automationName": "uiautomator2",
  "newCommandTimeout": "120",
  "appPackage": "com.android.calculator2",
  "appActivity": "com.android.calculator2.Calculator"
}
or to app
{
  "platformName": "Android",
  "deviceName": "0042825151",
  "automationName": "uiautomator2",
  "newCommandTimeout": "120",
  "app": "C:/CTAppium-1-1.apk"
}
```

### 4.2) Element capture by uiautomatorviewer
After installing Androis Studio, run on cmd 

uiautomatorviewer

But you need the appium server to be running


## 5) Install maven - just to run from the command line if needed (Optional)
### Download and install
https://maven.apache.org/download.cgi#

apache-maven-3.6.3-bin.zip 
in a folder of PC

- Environment variable settings
	- Create: M2_HOME = C:\Program Files\apache-maven-3.6.3
	- Path: %M2_HOME%\bin;

### To run by .bat file (inside file)

```
@echo off
echo ...........................................................................................
echo Open folder of project that contain the file pom.xml
cd %userprofile%\local frame\Framework-full
echo ...........................................................................................
echo to run
mvn test
echo ...........................................................................................
```

## 6) Install Node.js - just to run Appium Server automatically
### Install
-Link:
https://nodejs.org/

- Execute the program: Node.js command prompt
	- type: npm install -g appium
	- type: Appium -v

### Test if run
- **type:** appium -a 127.0.0.1 -p 4723

or see in the tutorial link how to install: 
http://www.automationtestinghub.com/download-and-install-appium-1-6/

complete tutoring, but the 1st option is already implemented in the code: 
http://www.automationtestinghub.com/3-ways-to-start-appium-server-from-java/

## 7) Connect and identify Cell, emulator or Farm
### Configure physical cell
Enable USB debugging located within developer options
To activate developer option just click the android version countless times

### Identify devices
With the device connected, type in cmd:
adb devices

### For cloud testing (Cell farm)
https://app.testobject.com/#/login
It usually has a cost and needs to change the entry at driver startup

## 8) Mount Winium DeskTop
Frame is already with the driver and with automatic startup
You only need to put the program you are going to run
and use one of the programs below to identify the elements

### Tutorial:
https://medium.com/@ferpioli/de-repente-me-deparo-com-um-cen%C3%A1rio-diferente-novo-emprego-cheio-de-desafios-e-oportunidades-f32af092ba02

### Driver
- Already attached to the project in src/main/resources/drivers/Winium.Desktop.Driver.exe
	- For download:
https://github.com/2gis/Winium.Desktop/releases

### For get elements
- https://www.autoitscript.com/site/autoit-script-editor/downloads/
- https://archive.codeplex.com/?p=uiautomationverify
- https://msdn.microsoft.com/Message-Error.htm?aspxerrorpath=/pt-br/library/ms727247(v=vs.110).aspx

 




# Helps to developer (Extra)

## 1) Xpath Helps

#### base commands
```
/	Seleciona a partir do nó raiz
//	Seleciona nós no documento a partir do nó atual que combina com a expressão, independente de onde estiver.
.	Seleciona o nó atual.
..	Seleciona o Pai do nó atual.
@	Seleciona os atributos (ID, NAME, CLASS, etc...)
*	Seleciona todos os elementos filhos do nó atual.
@*	Seleciona todos atributos do nó atual.
```

#### Get contain text
//button[contains(text(),'abcd')]

#### Get specific text
//span[normalize-space(text())='texto Procurado']

//button[normalize-space(text())='abc']

#### ancestor = Contém todos os ancestrais (pais, avós, etc.) do nó atual. 
//*[text()='Site']/ancestor::tbody

#### ancestor-or-self = Contém o nó atual + todos os seus ancestrais (pai, avô, etc.)
//*[text()='Dados de cadastro']/ancestor-or-self::*[contains(@class,'ui-panelgrid ui-widget')]

#### child = Contém todos os filhos do nó atual.
//*[text()='Tipo de pagamento']/ancestor::ul/child::li[4]

//*[text()='VP PRODUTOS, GESTAO E EXPA...']/../child::level

#### descendant = Contém todos os descendentes (filhos, netos, etc.) do nó atual.
//*[text()='Telefone']/ancestor::table/descendant::button

#### descendant-or-self = Contem o nó atual mais todos os seus descendentes (filhos, netos, etc.)
//*[text()='Dados de cadastro']/ancestor::table/descendant-or-self::td[contains(@class,'ui-panelgrid-cell')]

#### following = Contém tudo no documento depois da tag de fechamento do nó atual.
//*[text()='Estado']/following::label[1]

#### following-sibling = Contém todos os irmãos depois do nó atual.
//*[text()='CPF']/../following-sibling::th[2]

//*[text()='VP PRODUTOS, GESTAO E EXPA...']/../following-sibling::@level='1'

#### parent = Contém o pai do nó atual.
//*[text()='Estado']/parent::td

#### preceding = Seleciona todos os nós (com nós filhos) antes do nó atual no mesmo nível de hierarquia
//*[text()='Telefone']/preceding::span[contains(text(),'CPF')]

#### preceding-sibling = Seleciona todos os irmãos antes do nó atual.
//*[text()='Telefone']/parent::th/preceding-sibling::th

#### self = Seleciona o nó atual.
//*[text()='CPF']/ancestor::table/descendant::td/self::td[contains(text(),'643.255.752-60')]/ancestor::tbody/descendant::button[1]/child::span[1]


### Extensions in Chrome browser to help with xpath
ChroPath - 6.1.5

xPath Finder - 1.0.1

### Mock API
to create APIs in Mok
http://5b49f9b0ff11b100149bf42b.mockapi.io/cm/startup


## 2) Eclipse Installation 

 - preferably Eclipse Oxygen
https://www.eclipse.org/downloads/packages/release/oxygen/3a

- plugins: Help / Eclipse Marketplace...

- ANSI Escape in Console => to use color in console: This Eclipse plugin interprets the ANSI escape sequences to color the console output. It works for output text with escape sequences directly from Java, Groovy

- Darkest Dark Theme with DevStyle => To use dark theme: Darkest Dark is now DevStyle - a free plugin providing an enhanced set of experiences for Eclipse. Included: 	Darkest Dark theme - #1 in the Marketplace: 	True

- DBeaver 7.0.0 => To use connection DB SQL Server: DBeaver is free universal SQL client/database tool for developers and database administrators. It can work with any database server which has JDBC or ODBC driver...
-----> to install the driver ODB SQL: https://www.microsoft.com/en-us/download/details.aspx?id=57175 

- TestNG for Eclipse => This plug-in lets you run your TestNG tests from Eclipse. You can run suites, groups or individual methods. Errors are reported in a separate tab that lets you...  more info
--> After install => in Java Build Path => Library => add Library => TestNG

- Cucumber Eclipse Plugin => Help -> Install new software
Work with: http://cucumber.github.io/cucumber-eclipse/update-site/

- C:\Users\user\.m2\repository\org\projectlombok\lombok\1.18.12\lombok-1.18.12.jar
Run this file and install/update
