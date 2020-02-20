package fr.cnam.partiel;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import static javax.swing.JOptionPane.showMessageDialog;

public class NetflixTracker extends JPanel {
    private final DefaultTableModel tableModel = new DefaultTableModel(new Object[]{"Titre", "Progression", "Note globale"}, 0);

    private final Catalog catalog = Catalog.buildDefaultCatalog();

    public NetflixTracker() {
        super(new BorderLayout());

        // Create a centered title label
        final JLabel title = new JLabel("Séries Netflix");
        final JPanel titlePane = new JPanel();
        titlePane.setBorder(BorderFactory.createEmptyBorder(0, 0, 3, 0));
        titlePane.setMaximumSize(new Dimension(titlePane.getMaximumSize().width, titlePane.getPreferredSize().height));
        titlePane.add(title);

        // Create the table
        final JTable table = new JTable(this.tableModel);
        // TODO (Partie 2) Il faudrait que la table affiche les séries présentes dans le catalogue (pensez à factoriser)
        /*table.add rorws data*/
        Iterator<Series> itCatalog = this.catalog.iterator();

        while (itCatalog.hasNext()) {
            Series uneSerie = itCatalog.next();
            String titreSerie = uneSerie.getName();
            int progressionSerie = uneSerie.getProgression();
            double noteGlbSerie = uneSerie.getScore();
            tableModel.addRow(new Object[]{titreSerie, progressionSerie, noteGlbSerie});
        }

        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setFillsViewportHeight(true);
        final DefaultTableCellRenderer centering = new DefaultTableCellRenderer();
        centering.setHorizontalAlignment(JLabel.CENTER);
        table.getColumnModel().getColumn(1).setCellRenderer(centering);
        table.getColumnModel().getColumn(2).setCellRenderer(centering);

        // Put it in a scroll pane if it becomes too long
        final JScrollPane tablePane = new JScrollPane(table);

        // Put the title and the table in the top half part of the frame, with little margin
        final JPanel topHalf = new JPanel();
        topHalf.setLayout(new BoxLayout(topHalf, BoxLayout.Y_AXIS));
        topHalf.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        topHalf.add(titlePane);
        topHalf.add(tablePane);
        this.add(topHalf, BorderLayout.CENTER);

        // Progression control panel
        final JPanel progressionPane = new JPanel();
        // TODO (Partie 2) Codez ici la zone de contrôle de la progression d'une série
        final JPanel progressionSeriesPane = new JPanel();
        final JLabel notePane = new JLabel("Note: ");
        final JTextField noteField = new JTextField(5);
        final JButton noteIncButton = new JButton("+1");
        noteIncButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int selectedrow = table.getSelectedRow();
                    int column = 0;
                    String selectedSerireName = table.getModel().getValueAt(selectedrow, column).toString();
                    catalog.getSeriesForName(selectedSerireName).watch(3.2);
                }catch (ArrayIndexOutOfBoundsException ex){
                    showMessageDialog(null, "Veuillez Selectionner une serie dans le tableau");
                }
            }
        });

        progressionSeriesPane.add(notePane);
        progressionSeriesPane.add(noteField);
        progressionSeriesPane.add(noteIncButton);


        // New series control panel
        final JPanel newSeriesPane = new JPanel();
        final JLabel nameLabel = new JLabel("Titre de la série:");
        final JTextField nameField = new JTextField(20);
        final JLabel epCountLabel = new JLabel("Nb d'eps:");
        final JTextField epCountField = new JTextField(3);
        final JButton addButton = new JButton("+");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                catalog.newSeries(nameField.getText(),Integer.parseInt((epCountField.getText())));
            }
        });
        newSeriesPane.add(nameLabel);
        newSeriesPane.add(nameField);
        newSeriesPane.add(epCountLabel);
        newSeriesPane.add(epCountField);
        newSeriesPane.add(addButton);

        // Control panel layout
        final JPanel bottomHalf = new JPanel();
        bottomHalf.setLayout(new BoxLayout(bottomHalf, BoxLayout.Y_AXIS));

        // Put the control panels at the bottom of the frame
        bottomHalf.add(new JSeparator());
        bottomHalf.add(progressionSeriesPane);
        bottomHalf.add(progressionPane);
        bottomHalf.add(newSeriesPane);
        this.add(bottomHalf, BorderLayout.PAGE_END);





    }





    private static void createAndShowGUI() {
        // Create and set up the window.
        JFrame frame = new JFrame("Séries Netflix");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create and set up the content pane.
        NetflixTracker netflixTracker = new NetflixTracker();
        netflixTracker.setOpaque(true);
        frame.setContentPane(netflixTracker);

        // Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(NetflixTracker::createAndShowGUI);
    }
}
