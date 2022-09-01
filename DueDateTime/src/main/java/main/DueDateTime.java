package main;

import java.util.Calendar;
import java.util.Date;

import org.w3c.dom.ls.LSOutput;

import dao.TerminDao;
import service.TerminService;
import view.MainFrame;
import view.MainPanel;
import view.ViewBuilder;

public class DueDateTime {

	public static void main(String[] args) {

		System.out.println("App startet...");

		Date date = new Date();
// rgretgrtgbtrgb
		Calendar calendar = Calendar.getInstance();
		calendar.set(2022, 9, 1, 8, 52, 0);
		System.out.println(date.getTime());
		System.out.println(calendar.getTime());
		System.out.println(calendar.getTimeInMillis());

		System.out.println();

		System.out.println(calendar.getTimeInMillis() - Calendar.getInstance().getTimeInMillis());
//		TerminService terminService = new TerminService();
//		terminService.addTermin();
//		System.out.println(terminService.getTerminFilePath());
//
//		new TerminDao() {
//			@Override
//			public String getTerminFilePath() {
//				// TODO Auto-generated method stub
//				return "Hallo";
//			}
//		};
		// fgfdbfdhdf
//		MainPanel mainPanel = new MainPanel();
//		MainFrame mainFrame = new MainFrame(mainPanel);
//
//		ViewBuilder viewBuilder = new ViewBuilder();
//		viewBuilder.loadStartView(new MainPanel());

	}

}
