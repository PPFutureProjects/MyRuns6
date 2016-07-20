package edu.dartmouth.cs.reshmi.myruns;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.dartmouth.cs.reshmi.myruns.data.ExerciseEntryDataSource;


public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String id = req.getParameter("mId");
        if (id == null) { return; }

        // Delete the entry with the given ID, send message, and redirect to query.
        ExerciseEntryDataSource.delete(id);
        MessagingEndpoint msg = new MessagingEndpoint();
        msg.sendMessage("Delete:"+id);
        resp.sendRedirect("/query.do");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req, resp);
    }
}
