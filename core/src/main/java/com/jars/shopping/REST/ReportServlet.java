package com.jars.shopping.REST;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by marcinpankowski on 04.02.17.
 */
@WebServlet(urlPatterns = "/report")
public class ReportServlet extends HttpServlet {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReportServlet.class);
    private static final Marker REPORTSERVLET = MarkerFactory.getMarker("REPORT_SERVLET");

    @Inject
    ClientForAPI clientForAPI;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        LOGGER.info(REPORTSERVLET, "Pobierz dane do raportu o userach");

        DateToEpochConverter dateToEpochConverter = new DateToEpochConverter(req).invoke();
        long startDateEpoch = dateToEpochConverter.getStartDateEpoch();
        long endDateEpoch = dateToEpochConverter.getEndDateEpoch();


        List<UserData> usersToPrint = new ArrayList<>();

        try {
            usersToPrint = clientForAPI.getDataFromAPI(startDateEpoch, endDateEpoch);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        List<UserDataForGUI> userDataForGUIs = UserDataPOJO.getDataForGUI(usersToPrint);

        req.setAttribute("usersToPrint", usersToPrint);
        req.setAttribute("userDataForGUIs", userDataForGUIs);


        RequestDispatcher dispatcher = req.getRequestDispatcher("/report.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {


        RequestDispatcher dispatcher = req.getRequestDispatcher("/report.jsp");
        dispatcher.forward(req, resp);
    }

    private class DateToEpochConverter {
        private HttpServletRequest req;
        private long startDateEpoch;
        private long endDateEpoch;

        public DateToEpochConverter(HttpServletRequest req) {
            this.req = req;
        }

        public long getStartDateEpoch() {
            return startDateEpoch;
        }

        public long getEndDateEpoch() {
            return endDateEpoch;
        }

        public DateToEpochConverter invoke() {
            LOGGER.info(REPORTSERVLET, "Pobierz datę początkową");
            String startDate = req.getParameter("startDate");

            LOGGER.info(REPORTSERVLET, "Pobierz datę końcową");
            String endDate = req.getParameter("endDate");

            SimpleDateFormat availDate = new SimpleDateFormat("yyyy-MM-dd");
            startDateEpoch = 0;
            endDateEpoch = 0;
            ZoneId zoneId = ZoneId.systemDefault();

            if ((startDate != null)) {
                try {
                    Date sDate = availDate.parse(startDate);
                    startDateEpoch = sDate.getTime();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            } else {
                LocalDate fromDate = LocalDate.now().minusYears(2);
                startDateEpoch = fromDate.atStartOfDay(zoneId).toEpochSecond();
            }
            if ((endDate != null)) {
                try {
                    Date eDate = availDate.parse(endDate);
                    endDateEpoch = eDate.getTime();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            } else {
                LocalDate toDate = LocalDate.now().plusYears(2);
                endDateEpoch = toDate.atStartOfDay(zoneId).toEpochSecond();
            }
            return this;
        }
    }
}
