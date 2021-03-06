package pl.edu.agh.mwo.commodore64;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Report1 {

	private TreeMap<String, Double> reportDatas = new TreeMap<String, Double>();
	private ArrayList<Task> filtredDatas = new ArrayList<Task>();
	private double temp;

	// for Excel print
	private static String[] columns = { "Lp", "Pracownik", "Godziny [h]" };
	private static ArrayList<String[]> data = new ArrayList<>();

	public Report1(ArrayList<Task> tasks, String yearFilter) {

		data.clear();
		if (ifYearExists(tasks, yearFilter)) {
			System.out.println("++++++++++++++++++++++++++++++++++++++++++");
			System.out.println("Alfabetyczna lista pracowników za rok " + yearFilter);
			for (Task i : tasks) {
				if (i.getYear().equals(yearFilter)) {
					filtredDatas.add(i);
				}
	
			}
			fillReport();
			printReport();
		}
	}

	public void fillReport() {

		for (Task i : filtredDatas) {
			if (reportDatas.containsKey(i.getPerson()) == true) {
				temp = reportDatas.get(i.getPerson()) + Double.parseDouble(i.getHours());
				reportDatas.replace(i.getPerson(), temp);
			} else {
				reportDatas.put(i.getPerson(), Double.parseDouble(i.getHours()));
			}
		}

	}

	public void printReport() {
		double sum = 0;
		int index = 1;

		System.out.printf("%-10s %-30s %-10s\n", columns);

		for (Map.Entry<String, Double> entry : reportDatas.entrySet()) {
			String person = entry.getKey();
			Double hours = entry.getValue();
			int hoursVal = 0;

			if (hours % 1 == 0) {
				hoursVal = (int) Math.round(hours);
				String[] values = { String.valueOf(index), person, String.valueOf(hoursVal)};
				System.out.printf("%-10s %-30s %-10s\n", values);
				data.add(values);
			}
			else {
				String hoursStr = String.format("%1.2f", hours);
				String[] values = { String.valueOf(index), person, hoursStr };
				System.out.printf("%-10s %-30s %-10s\n", values);
				data.add(values);
			}
			sum += hours;
			index++;
		}
		String sumStr = String.format("%1.2f", sum);

		System.out.printf("%-41s %-10s", "Suma: ", sumStr);
		String[] sumFinal = { "Suma:", "", sumStr };
		data.add(sumFinal);
	}
	
	public boolean ifYearExists(ArrayList<Task> dataModel, String year) {
		for (Task t : dataModel) {
			if (t.getYear().equals(year))
				return true;
		}

		System.out.println("Brak danych na rok " + year);
		return false;
	}

	public static String[] getColumns() {
		return columns;
	}

	public void setColumns(String[] columns) {
		this.columns = columns;
	}

	public static ArrayList<String[]> getData() {
		return data;
	}

	public void setData(ArrayList<String[]> data) {
		this.data = data;
	}
}