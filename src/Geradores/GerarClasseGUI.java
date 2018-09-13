package Geradores;

import java.util.ArrayList;
import java.util.List;
import myTools.Ferramentas;

/**
 *
 * @author radames
 */
public class GerarClasseGUI {

    String projetoDestino;
    String nomeClasse;

    public GerarClasseGUI(String projetoDestino, String nomeClasse) {
        this.projetoDestino = projetoDestino;
        this.nomeClasse = nomeClasse;
        gerarClasseGUI();
    }

    private void gerarClasseGUI() {
        Ferramentas ferramentas = new Ferramentas();

        List<String> arquivoBase = ferramentas.abrirArquivo("src/Main/" + nomeClasse + ".txt");

        List<String> codigoGerado = new ArrayList<>();

        //fazer a classe de gui de lista
        codigoGerado.clear();
        codigoGerado.add("package Main;\n"
                + "\n"
                + "import java.awt.Font;\n"
                + "import java.awt.BorderLayout;\n"
                + "import java.awt.CardLayout;\n"
                + "import java.awt.Color;\n"
                + "import java.awt.Container;\n"
                + "import java.awt.FlowLayout;\n"
                + "import java.awt.GridLayout;\n"
                + "import java.awt.KeyEventDispatcher;\n"
                + "import java.awt.KeyboardFocusManager;\n"
                + "import java.awt.event.ActionEvent;\n"
                + "import java.awt.event.ActionListener;\n"
                + "import java.awt.event.ItemEvent;\n"
                + "import java.awt.event.ItemListener;\n"
                + "import java.awt.event.KeyEvent;\n"
                + "import java.awt.event.KeyListener;\n"
                + "import java.awt.event.MouseEvent;\n"
                + "import java.awt.event.MouseListener;\n"
                + "import java.awt.event.WindowAdapter;\n"
                + "import java.awt.event.WindowEvent;\n"
                + "import java.awt.event.WindowListener;\n"
                + "import java.io.IOException;\n"
                + "import java.util.ArrayList;\n"
                + "import java.util.List;\n"
                + "import java.util.logging.Level;\n"
                + "import java.util.logging.Logger;\n"
                + "import javax.swing.ButtonGroup;\n"
                + "import javax.swing.DefaultListModel;\n"
                + "import javax.swing.ImageIcon;\n"
                + "import javax.swing.JButton;\n"
                + "import javax.swing.JColorChooser;\n"
                + "import javax.swing.JComboBox;\n"
                + "import javax.swing.JFrame;\n"
                + "import javax.swing.JLabel;\n"
                + "import javax.swing.JList;\n"
                + "import javax.swing.JMenu;\n"
                + "import javax.swing.JMenuItem;\n"
                + "import javax.swing.JOptionPane;\n"
                + "import javax.swing.JPanel;\n"
                + "import javax.swing.JPopupMenu;\n"
                + "import javax.swing.JRadioButton;\n"
                + "import javax.swing.JScrollPane;\n"
                + "import javax.swing.JTabbedPane;\n"
                + "import javax.swing.JTable;\n"
                + "import javax.swing.JTextArea;\n"
                + "import javax.swing.JTextField;\n"
                + "import javax.swing.event.ListSelectionEvent;\n"
                + "import javax.swing.event.ListSelectionListener;\n"
                + "import javax.swing.plaf.basic.BasicListUI;\n"
                + "import javax.swing.table.DefaultTableModel;\n"
                + "import javax.swing.text.DefaultCaret;\n"
                + "import myTools.Ferramentas;\n"
                + "import myTools.UsarGridBagLayout;");
        //import java.util.Date;
        for (String s : arquivoBase) {
            String aux[] = s.split(";");
            if (aux[0].equals("Date")) {
                codigoGerado.add("import java.util.Date;");
                break;
            }
        }
        
        codigoGerado.add("class GUI_"+ ferramentas.plMaius(nomeClasse)+ " extends JFrame {"
                + "private JPanel pnNorte = new JPanel(new FlowLayout(FlowLayout.LEFT));\n"
                + "    private JPanel pnCentro = new JPanel();\n"
                + "    private CardLayout cardLayout = new CardLayout();\n"
                + "    private JPanel pnSul = new JPanel(cardLayout);\n"
                + "    private JPanel pnSulMsg = new JPanel();\n"
                + "    private JPanel pnSulListagem = new JPanel(new GridLayout(1, 1));\n"
                + "    private JPanel pnEast = new JPanel(new FlowLayout(FlowLayout.RIGHT));\n"
                + "    private JPanel pnWest = new JPanel(new GridLayout(2,2));"
                + "    private JButton btBuscar = new JButton(\"Buscar\");\n"
                + "    private JButton btInserir = new JButton(\"Inserir\");\n"
                + "    private JButton btAlterar = new JButton(\"Alterar\");\n"
                + "    private JButton btExcluir = new JButton(\"Excluir\");\n"
                + "    private JButton btListar = new JButton(\"Listar\");\n"
                + "    private JButton btSalvar = new JButton(\"Salvar\");\n"
                + "    private JButton btCancelar = new JButton(\"Cancelar\");\n"
                + "    private JButton btGravar = new JButton(\"Gravar\");\n"
                + "    private JButton btColorChooserBackground = new JButton(\"(F1)Cor do fundo\");\n"
                + "    private JButton btVoltarMenu = new JButton();\n"
                + "    \n"
                + "    private JComboBox comboBox = new JComboBox();\n"
                + "    private JRadioButton radiobtcombobox = new JRadioButton();\n"
                + "    private JRadioButton radiobtlistbox = new JRadioButton();");

        codigoGerado.add("\n}");

        //....
        String cc = projetoDestino + "/src/Main/" + nomeClasse + "GUI.java";
        System.out.println("Vai criar a classe nesse caminho=> " + cc);
        ferramentas.salvarArquivo(cc, codigoGerado);

    }

}