package com.company;

import org.apache.commons.math3.linear.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static java.util.Locale.US;

public class Main {

    private static double[][] usdPrices;
    private static double dispersionUsd;
    private static double dispersionPrices;

    public static void main(String[] args) {
        usdPrices = getValuesFromFile("D://Java.txt");
        calculateDispersionRx();
        calculateDispersionRy();
        initUI();
    }

    public static double[] transitionFunction() {
        double s1,s2,s3,s4,s5,s6,s7;
        double[] transitionArray = new double[8];
        s1 = impulseFunction()[0] / 2;
        s2 = impulseFunction()[1] + impulseFunction()[0] / 2;
        s3 = impulseFunction()[2] + impulseFunction()[1] / 2;
        s4 = impulseFunction()[3] + impulseFunction()[2] / 2;
        s5 = impulseFunction()[4] + impulseFunction()[3] / 2;
        s6 = impulseFunction()[5] + impulseFunction()[4] / 2;
        s7 = impulseFunction()[6] + impulseFunction()[5] / 2;
        transitionArray[0] = 0;
        transitionArray[1] = s1;
        transitionArray[2] = transitionArray[1] + s2;
        transitionArray[3] = transitionArray[2] + s3;
        transitionArray[4] = transitionArray[3] + s4;
        transitionArray[5] = transitionArray[4] + s5;
        transitionArray[6] = transitionArray[5] + s6;
        transitionArray[7] = transitionArray[6] + s7;
        return transitionArray;
    }

    private static double[] impulseFunction() {
        double[] arrayRx = functionRx();
        double[] arrayRxy = functionRxy();
        double[][] tmpArrayLinear = new double[arrayRx.length - 1][arrayRxy.length - 1];
        double[] tmpArrayResult = new double[arrayRx.length - 1];
        double[] resultArray = new double[tmpArrayResult.length];

        for (int i = 0; i < tmpArrayResult.length; i++) {
            tmpArrayResult[i] = arrayRxy[i];
        }
        for (int i = 0; i < tmpArrayResult.length; i++) {
            tmpArrayLinear[0][i] = arrayRx[i + 1];
            tmpArrayLinear[1][i] = arrayRx[i];
        }
        for (int i = 0; i < tmpArrayResult.length - 1; i++) {
            tmpArrayLinear[2][i + 1] = arrayRx[i];
        }
        tmpArrayLinear[2][0] = arrayRx[1];
        for (int i = 0; i < tmpArrayResult.length - 2; i++) {
            tmpArrayLinear[3][i + 2] = arrayRx[i];
        }
        tmpArrayLinear[3][0] = arrayRx[2];
        tmpArrayLinear[3][1] = arrayRx[1];
        for (int i = 0; i < tmpArrayResult.length - 3; i++) {
            tmpArrayLinear[4][i + 3] = arrayRx[i];
        }
        tmpArrayLinear[4][0] = arrayRx[3];
        tmpArrayLinear[4][1] = arrayRx[2];
        tmpArrayLinear[4][2] = arrayRx[1];
        for (int i = 0; i < tmpArrayResult.length - 4; i++) {
            tmpArrayLinear[5][i + 4] = arrayRx[i];
        }
        tmpArrayLinear[5][0] = arrayRx[4];
        tmpArrayLinear[5][1] = arrayRx[3];
        tmpArrayLinear[5][2] = arrayRx[2];
        tmpArrayLinear[5][3] = arrayRx[1];
        for (int i = 0; i < tmpArrayResult.length - 5; i++) {
            tmpArrayLinear[6][i + 5] = arrayRx[i];
        }
        tmpArrayLinear[6][0] = arrayRx[5];
        tmpArrayLinear[6][1] = arrayRx[4];
        tmpArrayLinear[6][2] = arrayRx[3];
        tmpArrayLinear[6][3] = arrayRx[2];
        tmpArrayLinear[6][4] = arrayRx[1];

        RealMatrix coefficients = new Array2DRowRealMatrix(tmpArrayLinear,false);
        DecompositionSolver solver = new LUDecomposition(coefficients).getSolver();

        RealVector constants = new ArrayRealVector(tmpArrayResult,false);
        RealVector solution = solver.solve(constants);
        for (int i = 0; i < tmpArrayResult.length; i++) {
            resultArray[i] = solution.getEntry(i);
        }
        return resultArray;
    }


    private static double[] functionRx() {
        double[] arrayRx = new double[usdPrices.length / 4 + 1];

        for (int i = 0; i < arrayRx.length; i++) {
            double tmpSum = 0;
            for (int j = 1; j < usdPrices.length - i; j++) {
                tmpSum += (usdPrices[j][0] - calculateAverageRx(usdPrices)) * (usdPrices[j + i][0] - calculateAverageRx(usdPrices));
            }
            arrayRx[i] = tmpSum / ((usdPrices.length - i) * dispersionUsd);
        }
        return arrayRx;
    }

    private static double[] functionRxy() {
        double[] arrayRxy = new double[usdPrices.length / 4 + 1];

        for (int i = 0; i < arrayRxy.length; i++) {
            double tmpSum = 0;
            for (int j = 1; j < usdPrices.length - i; j++) {
                tmpSum += (usdPrices[j][0] - calculateAverageRx(usdPrices)) * (usdPrices[j + i][1] - calculateAverageRy(usdPrices));
            }
            arrayRxy[i] = tmpSum / ((usdPrices.length - i) * Math.sqrt(dispersionUsd) * Math.sqrt(dispersionPrices));
        }
        return arrayRxy;
    }

    private static void calculateDispersionRx() {
        for (int i = 0; i < usdPrices.length; i++) {
            dispersionUsd += (usdPrices[i][0] - calculateAverageRx(usdPrices)) * (usdPrices[i][0] - calculateAverageRx(usdPrices)) / (usdPrices.length - 1);
        }
    }

    private static void calculateDispersionRy() {
        for (int i = 0; i < usdPrices.length; i++) {
            dispersionPrices += (usdPrices[i][1] - calculateAverageRy(usdPrices)) * (usdPrices[i][1] - calculateAverageRy(usdPrices)) / (usdPrices.length - 1);
        }
    }


    private static double calculateAverageRx(double[][] usdPrices) {
        double sumUsd = 0;
        for (int i = 0; i < usdPrices.length; i++) {
            sumUsd += usdPrices[i][0];
        }
        return sumUsd / usdPrices.length;
    }

    private static double calculateAverageRy(double[][] usdPrices) {
        double sumPrices = 0;
        for (int i = 0; i < usdPrices.length; i++) {
            sumPrices += usdPrices[i][1];
        }
        return sumPrices / usdPrices.length;
    }

    private static double[][] getValuesFromFile(String filePath) {
        int n = 0;
        File file = new File(filePath);

        try {
            Scanner scanner = new Scanner(file);
            scanner.useLocale(US);
            while (scanner.hasNextDouble()) {
                scanner.nextDouble();
                n++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        double[][] usdPrices = new double[n / 2][2];

        try {
            Scanner scanner = new Scanner(file);
            scanner.useLocale(US);
            while (scanner.hasNextDouble()) {
                for (int i = 0; i < usdPrices.length; i++) {
                    for (int j = 0; j < 2; j++) {
                        usdPrices[i][j] = scanner.nextDouble();
                    }
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return usdPrices;
    }

    private static void initUI() {
        JFrame ResultsWindow = new JFrame(); // adding window
        ResultsWindow.setVisible(true);
        ResultsWindow.setTitle("ResearchWork");

        Container a = ResultsWindow.getContentPane();
        a.setLayout(null);

        XYDataset dataset1 = createDataset(functionRx(),"Rx");
        XYDataset dataset2 = createDataset(functionRxy(),"Rxy");
        XYDataset dataset3 = createDatasetImpulse(impulseFunction(),"Impulse Function");
        XYDataset dataset4 = createDataset(transitionFunction(),"Transition Function");
        JFreeChart chart1 = createChart(dataset1, "Автокорреляционная функция");
        JFreeChart chart2 = createChart(dataset2, "Взаимокорреляционная функция");
        JFreeChart chart3 = createChart(dataset3, "Импульсная функция");
        JFreeChart chart4 = createChart(dataset4, "Переходная функция");
        ChartPanel chartPanel1 = new ChartPanel(chart1);
        ChartPanel chartPanel2 = new ChartPanel(chart2);
        ChartPanel chartPanel3 = new ChartPanel(chart3);
        ChartPanel chartPanel4 = new ChartPanel(chart4);
        chartPanel1.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel1.setBackground(Color.white);
        chartPanel1.setPreferredSize(new Dimension(600,450));
        chartPanel2.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel2.setBackground(Color.white);
        chartPanel2.setPreferredSize(new Dimension(600,450));
        chartPanel3.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel3.setBackground(Color.white);
        chartPanel3.setPreferredSize(new Dimension(600,450));
        chartPanel4.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel4.setBackground(Color.white);
        chartPanel4.setPreferredSize(new Dimension(600,450));
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        panel1.add(chartPanel1);
        panel2.add(chartPanel2);
        panel3.add(chartPanel3);
        panel4.add(chartPanel4);

        panel1.setBounds(20,20,600,450);
        panel2.setBounds(640,20,600,450);
        panel3.setBounds(20,490,600,450);
        panel4.setBounds(640,490,600,450);
        a.add(panel1);
        a.add(panel2);
        a.add(panel3);
        a.add(panel4);

        ResultsWindow.setExtendedState(JFrame.MAXIMIZED_BOTH);  // moved page position to the end because there were issues with Fields painting
        ResultsWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private static XYDataset createDataset(double[] result, String seriesName) {
        XYSeries series = new XYSeries(seriesName);
        double x, y;
        for (int i = 0; i < result.length; i++) {
            x = i;
            y = result[i];
            series.add(x, y);
        }
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);

        return dataset;
    }

    public static XYDataset createDatasetImpulse(double[] result, String seriesName) {
        XYSeries series = new XYSeries(seriesName);
        double x, y;
        for (int i = 1; i < result.length + 1; i++) {
            x = i;
            y = result[i - 1];
            series.add(x, y);
        }
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);

        return dataset;
    }

    private static JFreeChart createChart (XYDataset dataset, String textTitle){

        JFreeChart chart = ChartFactory.createXYLineChart(
                "ChartTitle",
                "x",
                "y",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        XYPlot plot = chart.getXYPlot();

        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(0, Color.RED);
        renderer.setSeriesStroke(0, new BasicStroke());

        plot.setRenderer(renderer);
        plot.setBackgroundPaint(Color.white);

        plot.setRangeGridlinesVisible(true);
        plot.setRangeGridlinePaint(Color.BLACK);

        plot.setDomainGridlinesVisible(true);
        plot.setDomainGridlinePaint(Color.BLACK);

        chart.getLegend().setFrame(BlockBorder.NONE);

        chart.setTitle(new TextTitle(textTitle,
                        new Font("Serif", java.awt.Font.BOLD, 18)
                )
        );

        return chart;
    }
}
