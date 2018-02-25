http://127.0.0.1:8080/surveyViewer/save - accepts post request to save answers with json in following format:

{"answers":[{"textResponse":"red","userId":"testuser1", "questionId":"1","category":"cat1"}, {"textResponse":"yellow","userId":"testuser2", "questionId":"2","category":"cat2"}, {"likertResponse":"5.5","userId":"testuser2", "questionId":"3","category":"cat2"}]}



http://127.0.0.1:8080/surveyViewer/answers - returns all answers

http://127.0.0.1:8080/surveyViewer/findAll - returns all questions

http://127.0.0.1:8080/surveyViewer/questions?cat=somecategory&count=n  - returns all questions for given category, limit results with count (optional)




