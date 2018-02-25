surveyapp_build.sql (DB create script) and surveyapp-config.properties can also be foune in (SurveyApp directory)


DB Configuration
*************************************************************************************************
Assumptions: DB has been created, running app in Apache Tomcat

Copy surveyapp-config.properties to location in local environment

Edit DB settings in surveyapp-config.properties as applicable

Add the following to $CATALINA_BASE/conf/context.xml:

    <Context>
        <Parameter value="[pathToFile]/surveyapp-config.properties" name="configurationPath"/>
    </Context>



URLs
*************************************************************************************************
http://127.0.0.1:8080/surveyViewer/save - accepts post request to save answers with json in following format:

{"answers":[{"textResponse":"red","userId":"testuser1", "questionId":"1","category":"cat1"}, {"textResponse":"yellow","userId":"testuser2", "questionId":"2","category":"cat2"}, {"likertResponse":"5.5","userId":"testuser2", "questionId":"3","category":"cat2"}]}



http://127.0.0.1:8080/surveyViewer/answers - returns all answers

http://127.0.0.1:8080/surveyViewer/findall - returns all questions

http://127.0.0.1:8080/surveyViewer/questions?cat=somecategory&count=n  - returns all questions for given category, limit results with count (optional)


Sample VUE pages:

http://127.0.0.1:8080/surveyViewer/hellovue.html
http://127.0.0.1:8080/surveyViewer/hello.html




