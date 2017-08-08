# HPQCJAPI

HPQCJAPI Syncs JUnit standard XML files into HP ALM QC.

## Usage
```
java -jar HPQCJAPI.jar [--args] Project_Name path\to\JUnitOuput.xml
```
A config.properties file is generated on your first run. It will look like this.
```
#Default properties to use for HPQCJAPI connections. Please adjust to your needs. Note that these can all be ignored with cli args. Also testSetId, testSetName, and guessTestSet are not required. TestSetId links directly to testset, name attempts to find the id matching the exact provided name, guess will simply use the tesetset folder from the last run (please mark guessTestSet with either true or false).
#Tue Aug 08 14:09:11 CDT 2017
#Domain to connect to for ALM. Expects ALM to always be located at ${HOST}:${PORT}/qcbin
host=whqwalm02.tyson.com
# Process Team name
team=BI - BW
# Port of HP ALM server
port=80
# Whether to print debug messages
verbose=false
# Which Project Domain to use in ALM
domain=PROJECTS
# Username to connect with
username=
# Password of ALM user. Suggested to use CLI arg instead of hardcode.
password=
#Project Name
project=SR23428_EnterpriseWaterMgmtSys
# ID of folder to use
testFolder=1018
# Not Required, ID of TestSet to use. Always better to manually supply ID over using guessTestSet or TestSetName
testSetId=
testSetName=
# Attempts to guess which testSet to use. Currently just uses testSet from last succesful run
guessTestSet=true
```
These values all associate to possible command line arguments, 

#### CLI Args
```
HPQCJAPI [...] [JUNITPATH] [TEST_NAME]
 -d,--domain <arg>          The domain in ALM to connect to. (defaults to PROJECTS)
 -D,--project <arg>         The project name to connect to (defaults to SR23428_EnterpriseWaterMgmtSys)
 -f,--testsetfolder <arg>   The test set folder id to use (defaults to 1018, Unit Testing)
 -g,--guessTestSet          Flag: Attempt to guess the test set. Currently does so by using the test set from the last executed run in HPQC
 -H,--host <arg>            The host domain to connect to. (Defaults to whqwalm02.tyson.com)
 -h,--help                  Print help information
 -P,--port <arg>            The port to connect to (defaults 80)
 -p,--password <arg>        The password to authenticate with. (defaults to empty)
 -s,--testSetId <arg>       Test set id to use [takes precedent over testSetName and guessTestSet] (defaults to empty)
 -S,--testSetName <arg>     Test set name to use [takes precedent over guessTestSet] (defaults to empty)
 -t,--team <arg>            The process team to set for the test (defaults to BI - BW)
 -u,--username <arg>        The username to authenticate with. (defaults to empty)
 -v,--verbose               Flag: Output debug information
```

## Dependencies

Dillinger uses a number of open source projects to work properly:

* [Java 8] - Lambdas n Reflections n Stuff
* [Commons CLI] - Argument Parsing
* [jSoup] - HTML Parsing
* [Maven] - Dependency managment

## Installation
```sh
$ cd hpqcjapi
$ mvn clean install
```

## Development

Required Reading: http://whqwalm02.tyson.com/qcbin/Help/doc_library/api_refs/REST/webframe.html#CSHID=General%2FFiltering.html|StartTopic=Content%2FGeneral%2FFiltering.html

As a crash course, ALM Rest is built on Entities, which are collections of objects Entity. An Entity has the following schema
![Map of Schema] (http://whqlisgit02.tyson.com/is-iot-streaming/hpqcjapi/blob/master/entityschema.png)

 [Java 8]: http://www.oracle.com/technetwork/java/javase/8u131-relnotes-3565278.html
 [Commons CLI]: https://commons.apache.org/proper/commons-cli/index.html
 [jsoup]: https://jsoup.org/
 [Maven]: https://maven.apache.org/