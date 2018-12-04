package ai.preferred.regression.plot;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;

public class XYChart extends JFrame {

  private static final long serialVersionUID = 1L;

  public XYChart(String chartTitle, XYSeries data, XYSeries line) {
    super("Linear Regression Plotter");
    final XYSeriesCollection collection = new XYSeriesCollection();
    collection.addSeries(data);
    collection.addSeries(line);
    final ChartPanel panel = new ChartPanel(createChart(collection, chartTitle));
    panel.setPreferredSize(new Dimension(640, 480));
    setContentPane(panel);
  }

  private JFreeChart createChart(XYDataset dataset, String title) {
    final JFreeChart chart = ChartFactory.createXYLineChart(title, "X", "Y", dataset);
    final XYPlot plot = chart.getXYPlot();
    final XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
    renderer.setSeriesLinesVisible(0, false);
    renderer.setSeriesShapesVisible(0, true);
    renderer.setSeriesLinesVisible(1, true);
    renderer.setSeriesShapesVisible(1, false);
    plot.setRenderer(renderer);
    return chart;
  }

}