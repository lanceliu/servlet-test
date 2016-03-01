package com.sishuok.chapter2.web.servlet;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 13-6-21 下午2:27
 * <p>Version: 1.0
 */
@WebServlet(urlPatterns = "/LongRunningServlet")
public class LongRunningServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        long startTime = System.currentTimeMillis();
        System.out.println("LongRunningServlet Start::Name="
                + Thread.currentThread().getName() + "::ID="
                + Thread.currentThread().getId());


        int secs = 3000;
        // max 10 seconds
        if (secs > 10000)
            secs = 10000;

        longProcessing(secs, response);

        PrintWriter out = response.getWriter();
        long endTime = System.currentTimeMillis();
        out.write("Processing done for " + secs + " milliseconds!!");
        System.out.println("LongRunningServlet Start::Name="
                + Thread.currentThread().getName() + "::ID="
                + Thread.currentThread().getId() + "::Time Taken="
                + (endTime - startTime) + " ms.");
    }

    private void longProcessing(int secs,HttpServletResponse response) throws IOException {
        // wait for given time before finishing
        try {
            Thread.sleep(secs);
            response.getWriter().write("over ,hahhh!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}