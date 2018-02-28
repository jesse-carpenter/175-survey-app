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

Sample VUE pages:

http://127.0.0.1:8080/surveyViewer/hellovue.html
http://127.0.0.1:8080/surveyViewer/hello.html


GET Methods:

http://127.0.0.1:8080/surveyViewer/questions

    Parameters:
        "id" - returns the question for the id
        "category" - returns all questions for given category, limit results with "count" (optional)
        Returns all questions if no parameters entered, limit results with "count" (optional)

http://127.0.0.1:8080/surveyViewer/answers

    Parameters:
        "category" - returns all answers for given category, limit results with "count" (optional)
        Returns all answers if no parameters entered, limit results with "count" (optional)

http://127.0.0.1:8080/surveyViewer/surveys

    Parameters:
        "id" - returns the survey for the id
        "title" - returns the surveys for the title
        Returns all questions if no parameters entered, limit results with "count" (optional)


POST Methods:


http://127.0.0.1:8080/surveyViewer/saveSurvey - saves survey populated with questions

    Sample JSON:

        {"title":"Another Great Survey", "questions":[{"question":"What did you have for breakfast?","category":"meals", "likert":"false"}, {"question":"What did you have for dinner?","category":"meals", "likert":"false"}]}


http://127.0.0.1:8080/surveyViewer/saveQuestions - saves questions, but does not currently link to survey.  To add orphaned questions to survey, get survey, get questions, update survey and save.

	Sample JSON:

        {"questions":[{"question":"What did you have for breakfast?","category":"meals", "likert":"false"}, {"question":"What did you have for dinner?","category":"meals", "likert":"false"}]}
		

http://127.0.0.1:8080/surveyViewer/saveAnswers - saves answers

	Sample JSON:

        {"answers":[{"textResponse":"red","userId":"testuser1", "questionId":"1","category":"cat1"}, {"textResponse":"yellow","userId":"testuser2", "questionId":"2","category":"cat2"}, {"likertResponse":"5.5","userId":"testuser2", "questionId":"3","category":"cat2"}]}













