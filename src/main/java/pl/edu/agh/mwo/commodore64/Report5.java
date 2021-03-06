package pl.edu.agh.mwo.commodore64;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Report5 {
	private ArrayList<Task> projectWorkers = new ArrayList<>();
	private TreeMap<String, Double> workingHours = new TreeMap<>();

	// for Excel print
	private static String[] columns = { "Lp", "Pracownik", "Godziny [h]" };
	private static ArrayList<String[]> data = new ArrayList<>();

	public Report5(ArrayList<Task> dataModel, String project) {
		
		data.clear();
		if (projectExistanceCheck(dataModel, project)) {
			System.out.println("++++++++++++++++++++++++++++++++++++++++++");
			System.out.println("Szczegółowy wykaz pracy w projekcie: " + project);
			for (Task t : dataModel) {
				if (t.getProject().equals(project))
					projectWorkers.add(t);
			}

			fillReport();
			printReport();
		}
	}

	public boolean projectExistanceCheck(ArrayList<Task> dataModel, String project) {
		for (Task t : dataModel) {
			if (t.getProject().equals(project))
				return true;
		}

		System.out.println("Projekt o nazwie " + project + " nie istnieje!");
		return false;
	}

	public void fillReport() {
		for (Task t : projectWorkers) {
			if (workingHours.containsKey(t.getPerson())) {
				double dayHours = workingHours.get(t.getPerson()) + Double.parseDouble(t.getHours());
				workingHours.replace(t.getPerson(), dayHours);
			} else
				workingHours.put(t.getPerson(), Double.parseDouble(t.getHours()));
		}
	}

	public void printReport() {
		double sum = 0;
		int index = 1;

		System.out.printf("%-10s %-30s %-10s\n", columns);

		for (Map.Entry<String, Double> entry : workingHours.entrySet()) {
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
