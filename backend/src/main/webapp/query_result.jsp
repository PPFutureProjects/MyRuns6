<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="edu.dartmouth.cs.reshmi.myruns.data.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
        integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
        crossorigin="anonymous">
        <title>MyRuns - Reshmi Suresh</title>
    </head>
    <body>
      <div class="container">
        <h1>Exercise Entries List</h1>

        <%
            String retStr = (String) request.getAttribute("_retStr");
            if (retStr != null) {
        %>
            <p><%=retStr%></p>
        <%
            }
        %>

        <table class="table table-hover">
          <thead>
            <tr>
              <th>ID</th>
              <th>Input Type</th>
              <th>Activity Type</th>
              <th>Date Time</th>
              <th>Duration</th>
              <th>Distance</th>
              <th>Average Speed</th>
              <th>Calories</th>
              <th>Climb</th>
              <th>Heart Rate</th>
              <th>Comment</th>
              <th>Action</th>
            </tr>
          </thead>
          <tbody>

            <%
                List<ExerciseEntry> resultEntries = (List<ExerciseEntry>) request
                    .getAttribute("AllEntries");
                if (resultEntries != null) {
                    for (ExerciseEntry entry : resultEntries) {
            %>
                <tr>
                    <td><%=entry.mId%></td>
                    <td><%=entry.mInputType%></td>
                    <td><%=entry.mActivityType%></td>
                    <td><%=entry.formatDate%></td>
                    <td><%=entry.mDuration%></td>
                    <td><%=entry.mDistance%></td>
                    <td><%=entry.mAvgSpeed%></td>
                    <td><%=entry.mCalorie%></td>
                    <td><%=entry.mClimb%></td>
                    <td><%=entry.mHeartRate%></td>
                    <td><%=entry.mComment%></td>
                    <td>
                        <a href="/delete.do?mId=<%=entry.mId%>">Delete</a>
                    </td>
                </tr>
            <%
                    }
                }
            %>

          </tbody>
        </table>

      </div>
    </body>
</html>
