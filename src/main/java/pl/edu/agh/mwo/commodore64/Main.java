package pl.edu.agh.mwo.commodore64;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Main
{
	public static void main(String[] args)
	{
		String reportsPath = Intro.welcomePage();
		PathCommander.getPath(reportsPath);
		
		/*
		 * //for checks for(Task t : PathCommander.getDataModel()) {
		 * 
		 * System.out.println("h - " + t.getHours() + " - m - " + t.getMonth() +
		 * " - y - " + t.getYear() + " - h - " + t.getProject() + " - p - " +
		 * t.getPerson()); }
		 */
		  
		//  ReportsSelector reportSelector = new ReportsSelector();
		 // reportSelector.SelectReport();
		
		
		Report4 test = new Report4(PathCommander.getDataModel(),"2019");
		
	}
}
