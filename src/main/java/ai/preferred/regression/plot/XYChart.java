/*
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

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