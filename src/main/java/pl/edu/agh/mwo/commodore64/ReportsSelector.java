package pl.edu.agh.mwo.commodore64;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ReportsSelector {

    Scanner scan = new Scanner(System.in);
    private int reportOption;

    public void PrintReportsWelcomeMessage(){
        System.out.println("Wybierz z ponizszych opcji raport ktory chcesz wygenerowac:");
        System.out.println("Raport 1: Alfabetyczna lista pracowników za dany rok. WPISZ: 1");
        System.out.println("Raport 2: Alfabetyczna lista projektów za dany rok. WPISZ: 2");
        System.out.println("Raport 3: Szczegółowy wykaz pracy danego pracownika. WPISZ: 3");
        System.out.println("Raport 4: Procentowe zaangażowanie danego pracownika w projekty za dany rok. WPISZ: 4");
        System.out.println("Raport 5: Szczegółowy wykaz pracy w danym projekcie, pokazujący liczbę godzin wypracowanych przez " +
                "poszczególnych pracowników w danym projekcie. WPISZ: 5");
        System.out.println("Raport 6: Generowanie wykresu słupkowego do raportu 2. WPISZ: 6");
        System.out.println("Raport 7: Wykres kołowy do raportu 4 dla danego pracownika. WPISZ: 7");
        System.out.println("Wyjscie z programu. WPISZ: 0");
    }

    public int GetReportOptionToGenerateFromUser(){
        System.out.print("\nWpisz wybrana opcje: ");
        reportOption = scan.nextInt();
        return reportOption;
    }

    public void GeneratingReportInfo(int reportOption){
       System.out.println("Generowanie raportu numer: " + reportOption);
    }

    public void CheckIfUserWantToGenerateAgain(){
        System.out.print("\nCzy chcesz wygenerowac kolejny raport? (WPISZ: 1 jesli TAK, wpisz 0 jesli NIE): ");
        int generationAgainStatus = scan.nextInt();
        if (generationAgainStatus == 1){
            SelectReport();
        }
        else {
            System.exit(0);
        }
    }

    public void SelectReport(){
        PrintReportsWelcomeMessage();
        try {
            reportOption = GetReportOptionToGenerateFromUser();
            switch (reportOption){
                case 1:
                    GeneratingReportInfo(reportOption);
                    System.out.print(1);
                    break;
                case 2:
                    GeneratingReportInfo(reportOption);
                    System.out.print(2);
                    break;
                case 3:
                    GeneratingReportInfo(reportOption);
                    System.out.print(3);
                    break;
                case 4:
                    GeneratingReportInfo(reportOption);
                    System.out.print(4);
                    break;
                case 5:
                    GeneratingReportInfo(reportOption);
                    System.out.print(5);
                    break;
                case 6:
                    GeneratingReportInfo(reportOption);
                    System.out.print(6);
                    break;
                case 7:
                    GeneratingReportInfo(reportOption);
                    System.out.print(7);
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Podana wartosc jest bledna, sprobuj ponownie.");
            }
            CheckIfUserWantToGenerateAgain();
        }
        catch (InputMismatchException err){
            System.out.println("\nPodana wartosc jest bledna, sprobuj ponownie.");
            SelectReport();
        }
    }
}