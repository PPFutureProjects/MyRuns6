package edu.dartmouth.cs.reshmi.myruns;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.dartmouth.cs.reshmi.myruns.data.ExerciseEntry;
import edu.dartmouth.cs.reshmi.myruns.data.ExerciseEntryDataSource;


public class QueryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public static final String ALL_ENTRIES_KEY = "AllEntries";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // Get all entries and forward to JSP file
        List<ExerciseEntry> allEntries = ExerciseEntryDataSource.fetchAll();
        req.setAttribute(ALL_ENTRIES_KEY, allEntries);
        getServletContext().getRequestDispatcher("/query_result.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req, resp);
    }
}
