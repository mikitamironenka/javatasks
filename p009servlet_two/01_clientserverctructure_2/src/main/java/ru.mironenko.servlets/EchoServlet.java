package ru.mironenko.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class EchoServlet extends HttpServlet {

    private static final Logger LOG = LoggerFactory.getLogger(EchoServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        System.out.println(req.getServletPath());
        System.out.println(req.getServerPort());//порт
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        writer.append("hello world");
        writer.flush();
    }
}
