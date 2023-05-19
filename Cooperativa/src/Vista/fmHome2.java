/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Excel.ExcelAD;
import Excel.ExcelAF;
import Excel.ExcelAH;
import Excel.ExcelAP;
import Excel.ExcelBA;
import Excel.ExcelLI;
import Excel.ExcelOC;
import Excel.ExcelVE;
import Modelo.SqlUsuarios;
import Modelo.usuarios;
import PDF.pdfAD;
import PDF.pdfAF;
import PDF.pdfAH;
import PDF.pdfAP;
import PDF.pdfBA;
import PDF.pdfLI;
import PDF.pdfOC;
import PDF.pdfVE;
import javax.swing.ImageIcon;

/**
 *
 * @author maula
 */
public class fmHome2 extends javax.swing.JFrame {

    /**
     * Creates new form fmHome2
     */
    usuarios mod;
    SqlUsuarios usrC = new SqlUsuarios();
    public fmHome2() {
        initComponents();
        setTitle("Cooperativa");
        setLocationRelativeTo(null);
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes/32Coop.png")).getImage());
        btnAf.setVisible(false);
        btnAd.setVisible(false);
        btnAp.setVisible(false);
        btnAh.setVisible(false);
        btnBa.setVisible(false);
        btnLi.setVisible(false);
        btnOc.setVisible(false);
        btnVe.setVisible(false);
        btnRe.setVisible(false);
    }

    public fmHome2(usuarios mod) {
        initComponents();
        setTitle("Cooperativa");
        setLocationRelativeTo(null);
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes/32Coop.png")).getImage());
        btnAf.setVisible(false);
        btnAd.setVisible(false);
        btnAp.setVisible(false);
        btnAh.setVisible(false);
        btnBa.setVisible(false);
        btnLi.setVisible(false);
        btnOc.setVisible(false);
        btnVe.setVisible(false);
        btnRe.setVisible(false);
        this.mod = mod;

        if (mod.getId_tipo() == 1) {
            if (mod.getAf() == 1) {
                btnAf.setVisible(true);
            } else if (mod.getAf() == 2) {
                btnAf.setVisible(false);
            }
            
            if(mod.getAd()==1){
                btnAd.setVisible(true);
            }else if(mod.getAd()==2){
                btnAd.setVisible(false);
            }
            
            if (mod.getAp() == 1) {
                btnAp.setVisible(true);
            } else if (mod.getAp() == 2) {
                btnAp.setVisible(false);
            }
            
            if(mod.getAh()==1){
                btnAh.setVisible(true);
            }else if(mod.getAh()==2){
                btnAh.setVisible(false);
            }
            
            if (mod.getBa() == 1) {
                btnBa.setVisible(true);
            } else if (mod.getBa() == 2) {
                btnBa.setVisible(false);
            }
            
            if(mod.getLi()==1){
                btnLi.setVisible(true);
            }else if(mod.getLi()==2){
                btnLi.setVisible(false);
            }
            
            if (mod.getOc() == 1) {
                btnOc.setVisible(true);
            } else if (mod.getOc() == 2) {
                btnOc.setVisible(false);
            }
            
            if(mod.getVe()==1){
                btnVe.setVisible(true);
            }else if(mod.getVe()==2){
                btnVe.setVisible(false);
            }
            
            if(mod.getRe()==1){
                btnRe.setVisible(true);
            }else if(mod.getRe()==2){
                btnRe.setVisible(false);
            }

        } else if (mod.getId_tipo() == 2) {
            btnExcel.setEnabled(false);
            btnPDF.setEnabled(false);
            btnAhorro.setEnabled(false);
            btnAportacion.setEnabled(false);
            btnVentas.setEnabled(false);
            btnOcacional.setEnabled(false);
            popAH.setEnabled(false);
            popVE.setEnabled(false);
            popAP.setEnabled(false);
            popOC.setEnabled(false);
            
            if (mod.getAf() == 1) {
                btnAf.setVisible(true);
            } else if (mod.getAf() == 2) {
                btnAf.setVisible(false);
            }
            
            if(mod.getAd()==1){
                btnAd.setVisible(true);
            }else if(mod.getAd()==2){
                btnAd.setVisible(false);
            }
            
            if (mod.getAp() == 1) {
                btnAp.setVisible(true);
            } else if (mod.getAp() == 2) {
                btnAp.setVisible(false);
            }
            
            if(mod.getAh()==1){
                btnAh.setVisible(true);
            }else if(mod.getAh()==2){
                btnAh.setVisible(false);
            }
            
            if (mod.getBa() == 1) {
                btnBa.setVisible(true);
            } else if (mod.getBa() == 2) {
                btnBa.setVisible(false);
            }
            
            if(mod.getLi()==1){
                btnLi.setVisible(true);
            }else if(mod.getLi()==2){
                btnLi.setVisible(false);
            }
            
            if (mod.getOc() == 1) {
                btnOc.setVisible(true);
            } else if (mod.getOc() == 2) {
                btnOc.setVisible(false);
            }
            
            if(mod.getVe()==1){
                btnVe.setVisible(true);
            }else if(mod.getVe()==2){
                btnVe.setVisible(false);
            }
            
            if(mod.getRe()==1){
                btnRe.setVisible(true);
            }else if(mod.getRe()==2){
                btnRe.setVisible(false);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Menu = new javax.swing.JPopupMenu();
        popAF = new javax.swing.JMenuItem();
        popAD = new javax.swing.JMenuItem();
        popAP = new javax.swing.JMenuItem();
        popAH = new javax.swing.JMenuItem();
        popBA = new javax.swing.JMenuItem();
        popLI = new javax.swing.JMenuItem();
        popOC = new javax.swing.JMenuItem();
        popVE = new javax.swing.JMenuItem();
        popRE = new javax.swing.JMenuItem();
        AF = new javax.swing.JPopupMenu();
        AfQuitar = new javax.swing.JMenuItem();
        AD = new javax.swing.JPopupMenu();
        AdQuitar = new javax.swing.JMenuItem();
        AP = new javax.swing.JPopupMenu();
        ApQuitar = new javax.swing.JMenuItem();
        AH = new javax.swing.JPopupMenu();
        AhQuitar = new javax.swing.JMenuItem();
        BA = new javax.swing.JPopupMenu();
        BaQuitar = new javax.swing.JMenuItem();
        LI = new javax.swing.JPopupMenu();
        LiQuitar = new javax.swing.JMenuItem();
        OC = new javax.swing.JPopupMenu();
        OcQuitar = new javax.swing.JMenuItem();
        VE = new javax.swing.JPopupMenu();
        VeQuitar = new javax.swing.JMenuItem();
        RE = new javax.swing.JPopupMenu();
        ReQuitar = new javax.swing.JMenuItem();
        escritorio = new javax.swing.JDesktopPane();
        btnAf = new javax.swing.JButton();
        btnAd = new javax.swing.JButton();
        btnAp = new javax.swing.JButton();
        btnAh = new javax.swing.JButton();
        btnBa = new javax.swing.JButton();
        btnLi = new javax.swing.JButton();
        btnOc = new javax.swing.JButton();
        btnVe = new javax.swing.JButton();
        btnRe = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem19 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        btnAfiliacion = new javax.swing.JMenuItem();
        btnAdmision = new javax.swing.JMenuItem();
        btnAportacion = new javax.swing.JMenuItem();
        btnAhorro = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        btnBazar = new javax.swing.JMenuItem();
        btnLibros = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        btnOcacional = new javax.swing.JMenuItem();
        btnVentas = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        btnRegistro = new javax.swing.JMenuItem();
        btnExcel = new javax.swing.JMenu();
        btnAFexcel = new javax.swing.JMenuItem();
        btnADexcel = new javax.swing.JMenuItem();
        btnAPexcel = new javax.swing.JMenuItem();
        btnAHexcel = new javax.swing.JMenuItem();
        btnBAexcel = new javax.swing.JMenuItem();
        btnLIexcel = new javax.swing.JMenuItem();
        btnOCexcel = new javax.swing.JMenuItem();
        btnVEexcel = new javax.swing.JMenuItem();
        btnPDF = new javax.swing.JMenu();
        btnAFpdf = new javax.swing.JMenuItem();
        btnADpdf = new javax.swing.JMenuItem();
        btnAPpdf = new javax.swing.JMenuItem();
        btnAHpdf = new javax.swing.JMenuItem();
        btnBApdf = new javax.swing.JMenuItem();
        btnLIpdf = new javax.swing.JMenuItem();
        btnOCpdf = new javax.swing.JMenuItem();
        btnVEpdf = new javax.swing.JMenuItem();

        Menu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        popAF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgAF/AF.png"))); // NOI18N
        popAF.setText("Afiliacion");
        popAF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popAFActionPerformed(evt);
            }
        });
        Menu.add(popAF);

        popAD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgAD/AD.png"))); // NOI18N
        popAD.setText("Admision");
        popAD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popADActionPerformed(evt);
            }
        });
        Menu.add(popAD);

        popAP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgAP/AP.png"))); // NOI18N
        popAP.setText("Aportacion");
        popAP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popAPActionPerformed(evt);
            }
        });
        Menu.add(popAP);

        popAH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgAH/AH.png"))); // NOI18N
        popAH.setText("Ahorro");
        popAH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popAHActionPerformed(evt);
            }
        });
        Menu.add(popAH);

        popBA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgBA/BA.png"))); // NOI18N
        popBA.setText("Bazar");
        popBA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popBAActionPerformed(evt);
            }
        });
        Menu.add(popBA);

        popLI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgLI/LI.png"))); // NOI18N
        popLI.setText("Libros");
        popLI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popLIActionPerformed(evt);
            }
        });
        Menu.add(popLI);

        popOC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgOC/OC.png"))); // NOI18N
        popOC.setText("Ocasional");
        popOC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popOCActionPerformed(evt);
            }
        });
        Menu.add(popOC);

        popVE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgVE/VE.png"))); // NOI18N
        popVE.setText("Ventas");
        popVE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popVEActionPerformed(evt);
            }
        });
        Menu.add(popVE);

        popRE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgRE/RE.png"))); // NOI18N
        popRE.setText("Reportes");
        popRE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popREActionPerformed(evt);
            }
        });
        Menu.add(popRE);

        AfQuitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/basurero.png"))); // NOI18N
        AfQuitar.setText("Eliminar");
        AfQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AfQuitarActionPerformed(evt);
            }
        });
        AF.add(AfQuitar);

        AdQuitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/basurero.png"))); // NOI18N
        AdQuitar.setText("Eliminar");
        AdQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdQuitarActionPerformed(evt);
            }
        });
        AD.add(AdQuitar);

        ApQuitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/basurero.png"))); // NOI18N
        ApQuitar.setText("Eliminar");
        ApQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ApQuitarActionPerformed(evt);
            }
        });
        AP.add(ApQuitar);

        AhQuitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/basurero.png"))); // NOI18N
        AhQuitar.setText("Eliminar");
        AhQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AhQuitarActionPerformed(evt);
            }
        });
        AH.add(AhQuitar);

        BaQuitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/basurero.png"))); // NOI18N
        BaQuitar.setText("Eliminar");
        BaQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BaQuitarActionPerformed(evt);
            }
        });
        BA.add(BaQuitar);

        LiQuitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/basurero.png"))); // NOI18N
        LiQuitar.setText("Eliminar");
        LiQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LiQuitarActionPerformed(evt);
            }
        });
        LI.add(LiQuitar);

        OcQuitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/basurero.png"))); // NOI18N
        OcQuitar.setText("Eliminar");
        OcQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OcQuitarActionPerformed(evt);
            }
        });
        OC.add(OcQuitar);

        VeQuitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/basurero.png"))); // NOI18N
        VeQuitar.setText("Eliminar");
        VeQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VeQuitarActionPerformed(evt);
            }
        });
        VE.add(VeQuitar);

        ReQuitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/basurero.png"))); // NOI18N
        ReQuitar.setText("Eliminar");
        ReQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReQuitarActionPerformed(evt);
            }
        });
        RE.add(ReQuitar);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnAf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgAF/btnAF.png"))); // NOI18N
        btnAf.setToolTipText("Afiliacion");
        btnAf.setBorderPainted(false);
        btnAf.setComponentPopupMenu(AF);
        btnAf.setContentAreaFilled(false);
        btnAf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAfActionPerformed(evt);
            }
        });

        btnAd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgAD/btnAD.png"))); // NOI18N
        btnAd.setToolTipText("Admision");
        btnAd.setBorderPainted(false);
        btnAd.setComponentPopupMenu(AD);
        btnAd.setContentAreaFilled(false);
        btnAd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdActionPerformed(evt);
            }
        });

        btnAp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgAP/btnAP.png"))); // NOI18N
        btnAp.setToolTipText("Aportacion");
        btnAp.setBorderPainted(false);
        btnAp.setComponentPopupMenu(AP);
        btnAp.setContentAreaFilled(false);
        btnAp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApActionPerformed(evt);
            }
        });

        btnAh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgAH/btnAH.png"))); // NOI18N
        btnAh.setToolTipText("Ahorro");
        btnAh.setBorderPainted(false);
        btnAh.setComponentPopupMenu(AH);
        btnAh.setContentAreaFilled(false);
        btnAh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAhActionPerformed(evt);
            }
        });

        btnBa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgBA/btnBA.png"))); // NOI18N
        btnBa.setToolTipText("Bazar");
        btnBa.setBorderPainted(false);
        btnBa.setComponentPopupMenu(BA);
        btnBa.setContentAreaFilled(false);
        btnBa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBaActionPerformed(evt);
            }
        });

        btnLi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgLI/btnLI.png"))); // NOI18N
        btnLi.setToolTipText("Libros");
        btnLi.setBorderPainted(false);
        btnLi.setComponentPopupMenu(LI);
        btnLi.setContentAreaFilled(false);
        btnLi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLiActionPerformed(evt);
            }
        });

        btnOc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgOC/btnOC.png"))); // NOI18N
        btnOc.setToolTipText("Ocasional");
        btnOc.setBorderPainted(false);
        btnOc.setComponentPopupMenu(OC);
        btnOc.setContentAreaFilled(false);
        btnOc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOcActionPerformed(evt);
            }
        });

        btnVe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgVE/btnVE.png"))); // NOI18N
        btnVe.setToolTipText("Ventas");
        btnVe.setBorderPainted(false);
        btnVe.setComponentPopupMenu(VE);
        btnVe.setContentAreaFilled(false);
        btnVe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVeActionPerformed(evt);
            }
        });

        btnRe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgRE/btnRE.png"))); // NOI18N
        btnRe.setToolTipText("Registros");
        btnRe.setBorderPainted(false);
        btnRe.setComponentPopupMenu(RE);
        btnRe.setContentAreaFilled(false);
        btnRe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(51, 60, 135));

        jLabel1.setForeground(new java.awt.Color(87, 123, 193));
        jLabel1.setText("Desarrollado por: Maurice Lang Bonilla");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("MaxiCoop R.L");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cooperativa.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jLabel3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(102, 102, 102)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(175, 175, 175)
                .addComponent(jLabel1))
        );

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escritorioLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnRe)
                    .addComponent(btnOc)
                    .addComponent(btnBa)
                    .addComponent(btnAp)
                    .addComponent(btnAf))
                .addGap(55, 55, 55)
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAd)
                    .addComponent(btnAh)
                    .addComponent(btnLi)
                    .addComponent(btnVe))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 657, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escritorioLayout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAf)
                    .addComponent(btnAd))
                .addGap(35, 35, 35)
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAp)
                    .addComponent(btnAh))
                .addGap(35, 35, 35)
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnBa)
                    .addComponent(btnLi))
                .addGap(35, 35, 35)
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnOc)
                    .addComponent(btnVe))
                .addGap(35, 35, 35)
                .addComponent(btnRe)
                .addContainerGap(105, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        escritorio.setLayer(btnAf, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(btnAd, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(btnAp, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(btnAh, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(btnBa, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(btnLi, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(btnOc, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(btnVe, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(btnRe, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jMenuBar1.setComponentPopupMenu(Menu);

        jMenu4.setText("Archivos");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/CerrarSesion_1.png"))); // NOI18N
        jMenuItem1.setText("Cerrar Sesion");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem1);

        jMenuItem19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Salir.png"))); // NOI18N
        jMenuItem19.setText("Salir");
        jMenuItem19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem19ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem19);

        jMenuBar1.add(jMenu4);

        jMenu1.setText("Ahorro");

        btnAfiliacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgAF/AF.png"))); // NOI18N
        btnAfiliacion.setText("Afiliacion");
        btnAfiliacion.setComponentPopupMenu(Menu);
        btnAfiliacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAfiliacionActionPerformed(evt);
            }
        });
        jMenu1.add(btnAfiliacion);

        btnAdmision.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgAD/AD.png"))); // NOI18N
        btnAdmision.setText("Admision");
        btnAdmision.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdmisionActionPerformed(evt);
            }
        });
        jMenu1.add(btnAdmision);

        btnAportacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgAP/AP.png"))); // NOI18N
        btnAportacion.setText("Aportacion");
        btnAportacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAportacionActionPerformed(evt);
            }
        });
        jMenu1.add(btnAportacion);

        btnAhorro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgAH/AH.png"))); // NOI18N
        btnAhorro.setText("Ahorro");
        btnAhorro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAhorroActionPerformed(evt);
            }
        });
        jMenu1.add(btnAhorro);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Inventario");

        btnBazar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgBA/BA.png"))); // NOI18N
        btnBazar.setText("Bazar");
        btnBazar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBazarActionPerformed(evt);
            }
        });
        jMenu2.add(btnBazar);

        btnLibros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgLI/LI.png"))); // NOI18N
        btnLibros.setText("Libros");
        btnLibros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLibrosActionPerformed(evt);
            }
        });
        jMenu2.add(btnLibros);

        jMenuBar1.add(jMenu2);

        jMenu5.setText("Ventas");

        btnOcacional.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgOC/OC.png"))); // NOI18N
        btnOcacional.setText("Ocasionales");
        btnOcacional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOcacionalActionPerformed(evt);
            }
        });
        jMenu5.add(btnOcacional);

        btnVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgVE/VE.png"))); // NOI18N
        btnVentas.setText("Ventas");
        btnVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentasActionPerformed(evt);
            }
        });
        jMenu5.add(btnVentas);

        jMenuBar1.add(jMenu5);

        jMenu3.setText("Registros");

        btnRegistro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgRE/RE.png"))); // NOI18N
        btnRegistro.setText("Ventas");
        btnRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistroActionPerformed(evt);
            }
        });
        jMenu3.add(btnRegistro);

        btnExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgRE/Excel.png"))); // NOI18N
        btnExcel.setText("Excel");
        btnExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcelActionPerformed(evt);
            }
        });

        btnAFexcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgAF/AF.png"))); // NOI18N
        btnAFexcel.setText("Afiliacion");
        btnAFexcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAFexcelActionPerformed(evt);
            }
        });
        btnExcel.add(btnAFexcel);

        btnADexcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgAD/AD.png"))); // NOI18N
        btnADexcel.setText("Adimision");
        btnADexcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnADexcelActionPerformed(evt);
            }
        });
        btnExcel.add(btnADexcel);

        btnAPexcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgAP/AP.png"))); // NOI18N
        btnAPexcel.setText("Aportacion");
        btnAPexcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAPexcelActionPerformed(evt);
            }
        });
        btnExcel.add(btnAPexcel);

        btnAHexcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgAH/AH.png"))); // NOI18N
        btnAHexcel.setText("Ahorro");
        btnAHexcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAHexcelActionPerformed(evt);
            }
        });
        btnExcel.add(btnAHexcel);

        btnBAexcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgBA/BA.png"))); // NOI18N
        btnBAexcel.setText("Bazar");
        btnBAexcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBAexcelActionPerformed(evt);
            }
        });
        btnExcel.add(btnBAexcel);

        btnLIexcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgLI/LI.png"))); // NOI18N
        btnLIexcel.setText("Libros");
        btnLIexcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLIexcelActionPerformed(evt);
            }
        });
        btnExcel.add(btnLIexcel);

        btnOCexcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgOC/OC.png"))); // NOI18N
        btnOCexcel.setText("Ocasional");
        btnOCexcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOCexcelActionPerformed(evt);
            }
        });
        btnExcel.add(btnOCexcel);

        btnVEexcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgVE/VE.png"))); // NOI18N
        btnVEexcel.setText("Ventas");
        btnVEexcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVEexcelActionPerformed(evt);
            }
        });
        btnExcel.add(btnVEexcel);

        jMenu3.add(btnExcel);

        btnPDF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgRE/PDF.png"))); // NOI18N
        btnPDF.setText("PDF");

        btnAFpdf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgAF/AF.png"))); // NOI18N
        btnAFpdf.setText("Afiliacion");
        btnAFpdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAFpdfActionPerformed(evt);
            }
        });
        btnPDF.add(btnAFpdf);

        btnADpdf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgAD/AD.png"))); // NOI18N
        btnADpdf.setText("Admision");
        btnADpdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnADpdfActionPerformed(evt);
            }
        });
        btnPDF.add(btnADpdf);

        btnAPpdf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgAP/AP.png"))); // NOI18N
        btnAPpdf.setText("Aportacion");
        btnAPpdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAPpdfActionPerformed(evt);
            }
        });
        btnPDF.add(btnAPpdf);

        btnAHpdf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgAH/AH.png"))); // NOI18N
        btnAHpdf.setText("Ahorro");
        btnAHpdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAHpdfActionPerformed(evt);
            }
        });
        btnPDF.add(btnAHpdf);

        btnBApdf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgBA/BA.png"))); // NOI18N
        btnBApdf.setText("Bazar");
        btnBApdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBApdfActionPerformed(evt);
            }
        });
        btnPDF.add(btnBApdf);

        btnLIpdf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgLI/LI.png"))); // NOI18N
        btnLIpdf.setText("Libros");
        btnLIpdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLIpdfActionPerformed(evt);
            }
        });
        btnPDF.add(btnLIpdf);

        btnOCpdf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgOC/OC.png"))); // NOI18N
        btnOCpdf.setText("Ocasional");
        btnOCpdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOCpdfActionPerformed(evt);
            }
        });
        btnPDF.add(btnOCpdf);

        btnVEpdf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgVE/VE.png"))); // NOI18N
        btnVEpdf.setText("Ventas");
        btnVEpdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVEpdfActionPerformed(evt);
            }
        });
        btnPDF.add(btnVEpdf);

        jMenu3.add(btnPDF);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAfiliacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAfiliacionActionPerformed

        fmAfiliacion af = new fmAfiliacion();
        escritorio.add(af);
        af.show();
    }//GEN-LAST:event_btnAfiliacionActionPerformed

    private void btnAdmisionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdmisionActionPerformed

        fmAdmision ad = new fmAdmision();
        escritorio.add(ad);
        ad.show();
    }//GEN-LAST:event_btnAdmisionActionPerformed

    private void btnAportacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAportacionActionPerformed

        fmAportacion ap = new fmAportacion();
        escritorio.add(ap);
        ap.show();
    }//GEN-LAST:event_btnAportacionActionPerformed

    private void btnAhorroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAhorroActionPerformed

        fmAhorro ah = new fmAhorro();
        escritorio.add(ah);
        ah.show();
    }//GEN-LAST:event_btnAhorroActionPerformed

    private void btnBazarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBazarActionPerformed

        fmBazar ba = new fmBazar();
        escritorio.add(ba);
        ba.show();
    }//GEN-LAST:event_btnBazarActionPerformed

    private void btnLibrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLibrosActionPerformed

        fmLibros li = new fmLibros();
        escritorio.add(li);
        li.show();
    }//GEN-LAST:event_btnLibrosActionPerformed

    private void btnOcacionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOcacionalActionPerformed

        fmOcasional oc = new fmOcasional();
        escritorio.add(oc);
        oc.show();
    }//GEN-LAST:event_btnOcacionalActionPerformed

    private void btnVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentasActionPerformed

        fmVentas ve = new fmVentas();
        escritorio.add(ve);
        ve.show();
    }//GEN-LAST:event_btnVentasActionPerformed

    private void btnExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcelActionPerformed


    }//GEN-LAST:event_btnExcelActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        this.dispose();

        fm Home = new fm();
        Home.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void btnAFpdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAFpdfActionPerformed

        pdfAF AF2 = new pdfAF();
        AF2.reporteAF();
    }//GEN-LAST:event_btnAFpdfActionPerformed

    private void btnADpdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnADpdfActionPerformed

        pdfAD AD2 = new pdfAD();
        AD2.reporteAD();
    }//GEN-LAST:event_btnADpdfActionPerformed

    private void btnAPpdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAPpdfActionPerformed

        pdfAP AP2 = new pdfAP();
        AP2.reporteAP();
    }//GEN-LAST:event_btnAPpdfActionPerformed

    private void btnAHpdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAHpdfActionPerformed

        pdfAH AH2 = new pdfAH();
        AH2.reporteAH();
    }//GEN-LAST:event_btnAHpdfActionPerformed

    private void btnBApdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBApdfActionPerformed

        pdfBA BA2 = new pdfBA();
        BA2.reporteBA();
    }//GEN-LAST:event_btnBApdfActionPerformed

    private void btnLIpdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLIpdfActionPerformed

        pdfLI LI2 = new pdfLI();
        LI2.reporteLI();
    }//GEN-LAST:event_btnLIpdfActionPerformed

    private void btnOCpdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOCpdfActionPerformed

        pdfOC OC2 = new pdfOC();
        OC2.reporteOC();
    }//GEN-LAST:event_btnOCpdfActionPerformed

    private void btnVEpdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVEpdfActionPerformed

        pdfVE VE2 = new pdfVE();
        VE2.reporteVE();
    }//GEN-LAST:event_btnVEpdfActionPerformed

    private void btnAFexcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAFexcelActionPerformed

        ExcelAF AF = new ExcelAF();
        AF.reporteAF();
    }//GEN-LAST:event_btnAFexcelActionPerformed

    private void btnADexcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnADexcelActionPerformed

        ExcelAD AD = new ExcelAD();
        AD.reporteAD();
    }//GEN-LAST:event_btnADexcelActionPerformed

    private void btnAPexcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAPexcelActionPerformed

        ExcelAP AP = new ExcelAP();
        AP.reporteAP();

    }//GEN-LAST:event_btnAPexcelActionPerformed

    private void btnAHexcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAHexcelActionPerformed

        ExcelAH AH = new ExcelAH();
        AH.reporteAH();
    }//GEN-LAST:event_btnAHexcelActionPerformed

    private void btnBAexcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBAexcelActionPerformed

        ExcelBA BA = new ExcelBA();
        BA.reporteBA();
    }//GEN-LAST:event_btnBAexcelActionPerformed

    private void btnLIexcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLIexcelActionPerformed

        ExcelLI LI = new ExcelLI();
        LI.reporteLI();
    }//GEN-LAST:event_btnLIexcelActionPerformed

    private void btnOCexcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOCexcelActionPerformed

        ExcelOC OC = new ExcelOC();
        OC.reporteOC();
    }//GEN-LAST:event_btnOCexcelActionPerformed

    private void btnVEexcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVEexcelActionPerformed

        ExcelVE VE = new ExcelVE();
        VE.reporteVE();
    }//GEN-LAST:event_btnVEexcelActionPerformed

    private void btnRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistroActionPerformed

        fmRegistro re = new fmRegistro();
        escritorio.add(re);
        re.show();
    }//GEN-LAST:event_btnRegistroActionPerformed

    private void jMenuItem19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem19ActionPerformed

        System.exit(0);
    }//GEN-LAST:event_jMenuItem19ActionPerformed

    private void popAFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popAFActionPerformed
        btnAf.setVisible(true);
        int a=1;
        int b=mod.getIde();
        
        mod.setAf(a);
        mod.setIde(b);

        if (usrC.afi(mod)) {
            System.out.println("Funciona");
        } else {
            System.out.println("No funciona");
        }
    }//GEN-LAST:event_popAFActionPerformed

    private void popADActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popADActionPerformed
        btnAd.setVisible(true);
        int a=1;
        int b=mod.getIde();
        
        mod.setAd(a);
        mod.setIde(b);

        if (usrC.adm(mod)) {
            System.out.println("Funciona");
        } else {
            System.out.println("No funciona");
        }
    }//GEN-LAST:event_popADActionPerformed

    private void AfQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AfQuitarActionPerformed
        btnAf.setVisible(false);
        int a=2;
        int b=mod.getIde();
        
        mod.setAf(a);
        mod.setIde(b);

        if (usrC.afi(mod)) {
            System.out.println("Funciona");
        } else {
            System.out.println("No funciona");
        }
    }//GEN-LAST:event_AfQuitarActionPerformed

    private void AdQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdQuitarActionPerformed
        btnAd.setVisible(false);
        int a=2;
        int b=mod.getIde();
        
        mod.setAd(a);
        mod.setIde(b);

        if (usrC.adm(mod)) {
            System.out.println("Funciona");
        } else {
            System.out.println("No funciona");
        }
    }//GEN-LAST:event_AdQuitarActionPerformed

    private void popAHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popAHActionPerformed
        btnAh.setVisible(true);
        int a=1;
        int b=mod.getIde();
        
        mod.setAh(a);
        mod.setIde(b);

        if (usrC.aho(mod)) {
            System.out.println("Funciona");
        } else {
            System.out.println("No funciona");
        }
    }//GEN-LAST:event_popAHActionPerformed

    private void popAPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popAPActionPerformed
        btnAp.setVisible(true);
        int a=1;
        int b=mod.getIde();
        
        mod.setAp(a);
        mod.setIde(b);

        if (usrC.apo(mod)) {
            System.out.println("Funciona");
        } else {
            System.out.println("No funciona");
        }
    }//GEN-LAST:event_popAPActionPerformed

    private void ApQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ApQuitarActionPerformed
        btnAp.setVisible(false);
        int a=2;
        int b=mod.getIde();
        
        mod.setAp(a);
        mod.setIde(b);

        if (usrC.apo(mod)) {
            System.out.println("Funciona");
        } else {
            System.out.println("No funciona");
        }
    }//GEN-LAST:event_ApQuitarActionPerformed

    private void AhQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AhQuitarActionPerformed
        btnAh.setVisible(false);
        int a=2;
        int b=mod.getIde();
        
        mod.setAh(a);
        mod.setIde(b);

        if (usrC.aho(mod)) {
            System.out.println("Funciona");
        } else {
            System.out.println("No funciona");
        }
    }//GEN-LAST:event_AhQuitarActionPerformed

    private void popBAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popBAActionPerformed
        btnBa.setVisible(true);
        int a=1;
        int b=mod.getIde();
        
        mod.setBa(a);
        mod.setIde(b);

        if (usrC.baz(mod)) {
            System.out.println("Funciona");
        } else {
            System.out.println("No funciona");
        }
    }//GEN-LAST:event_popBAActionPerformed

    private void popLIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popLIActionPerformed
        btnLi.setVisible(true);
        int a=1;
        int b=mod.getIde();
        
        mod.setLi(a);
        mod.setIde(b);

        if (usrC.lib(mod)) {
            System.out.println("Funciona");
        } else {
            System.out.println("No funciona");
        }
    }//GEN-LAST:event_popLIActionPerformed

    private void BaQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BaQuitarActionPerformed
        btnBa.setVisible(false);
        int a=2;
        int b=mod.getIde();
        
        mod.setBa(a);
        mod.setIde(b);

        if (usrC.baz(mod)) {
            System.out.println("Funciona");
        } else {
            System.out.println("No funciona");
        }
    }//GEN-LAST:event_BaQuitarActionPerformed

    private void LiQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LiQuitarActionPerformed
        btnLi.setVisible(false);
        int a=2;
        int b=mod.getIde();
        
        mod.setLi(a);
        mod.setIde(b);

        if (usrC.lib(mod)) {
            System.out.println("Funciona");
        } else {
            System.out.println("No funciona");
        }
    }//GEN-LAST:event_LiQuitarActionPerformed

    private void popOCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popOCActionPerformed
        btnOc.setVisible(true);
        int a=1;
        int b=mod.getIde();
        
        mod.setOc(a);
        mod.setIde(b);

        if (usrC.oca(mod)) {
            System.out.println("Funciona");
        } else {
            System.out.println("No funciona");
        }
    }//GEN-LAST:event_popOCActionPerformed

    private void popVEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popVEActionPerformed
        btnVe.setVisible(true);
        int a=1;
        int b=mod.getIde();
        
        mod.setVe(a);
        mod.setIde(b);

        if (usrC.ven(mod)) {
            System.out.println("Funciona");
        } else {
            System.out.println("No funciona");
        }
    }//GEN-LAST:event_popVEActionPerformed

    private void OcQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OcQuitarActionPerformed
        btnOc.setVisible(false);
        int a=2;
        int b=mod.getIde();
        
        mod.setOc(a);
        mod.setIde(b);

        if (usrC.oca(mod)) {
            System.out.println("Funciona");
        } else {
            System.out.println("No funciona");
        }
    }//GEN-LAST:event_OcQuitarActionPerformed

    private void VeQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VeQuitarActionPerformed
        btnVe.setVisible(false);
        int a=2;
        int b=mod.getIde();
        
        mod.setVe(a);
        mod.setIde(b);

        if (usrC.ven(mod)) {
            System.out.println("Funciona");
        } else {
            System.out.println("No funciona");
        }
    }//GEN-LAST:event_VeQuitarActionPerformed

    private void popREActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popREActionPerformed
        btnRe.setVisible(true);
        int a=1;
        int b=mod.getIde();
        
        mod.setRe(a);
        mod.setIde(b);

        if (usrC.reg(mod)) {
            System.out.println("Funciona");
        } else {
            System.out.println("No funciona");
        }
    }//GEN-LAST:event_popREActionPerformed

    private void ReQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReQuitarActionPerformed
        btnRe.setVisible(false);
        int a=2;
        int b=mod.getIde();
        
        mod.setRe(a);
        mod.setIde(b);

        if (usrC.reg(mod)) {
            System.out.println("Funciona");
        } else {
            System.out.println("No funciona");
        }
    }//GEN-LAST:event_ReQuitarActionPerformed

    private void btnAfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAfActionPerformed
        fmAfiliacion af = new fmAfiliacion();
        escritorio.add(af);
        af.show();
    }//GEN-LAST:event_btnAfActionPerformed

    private void btnAdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdActionPerformed
        fmAdmision ad = new fmAdmision();
        escritorio.add(ad);
        ad.show();
    }//GEN-LAST:event_btnAdActionPerformed

    private void btnApActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApActionPerformed
        fmAportacion ap = new fmAportacion();
        escritorio.add(ap);
        ap.show();
    }//GEN-LAST:event_btnApActionPerformed

    private void btnAhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAhActionPerformed
        fmAhorro ah = new fmAhorro();
        escritorio.add(ah);
        ah.show();
    }//GEN-LAST:event_btnAhActionPerformed

    private void btnBaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBaActionPerformed
        fmBazar ba = new fmBazar();
        escritorio.add(ba);
        ba.show();
    }//GEN-LAST:event_btnBaActionPerformed

    private void btnLiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLiActionPerformed
        fmLibros li = new fmLibros();
        escritorio.add(li);
        li.show();
    }//GEN-LAST:event_btnLiActionPerformed

    private void btnOcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOcActionPerformed
        fmOcasional oc = new fmOcasional();
        escritorio.add(oc);
        oc.show();
    }//GEN-LAST:event_btnOcActionPerformed

    private void btnVeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVeActionPerformed
        fmVentas ve = new fmVentas();
        escritorio.add(ve);
        ve.show();
    }//GEN-LAST:event_btnVeActionPerformed

    private void btnReActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReActionPerformed
        fmRegistro re = new fmRegistro();
        escritorio.add(re);
        re.show();
    }//GEN-LAST:event_btnReActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(fmHome2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fmHome2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fmHome2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fmHome2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fmHome2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPopupMenu AD;
    private javax.swing.JPopupMenu AF;
    private javax.swing.JPopupMenu AH;
    private javax.swing.JPopupMenu AP;
    private javax.swing.JMenuItem AdQuitar;
    private javax.swing.JMenuItem AfQuitar;
    private javax.swing.JMenuItem AhQuitar;
    private javax.swing.JMenuItem ApQuitar;
    private javax.swing.JPopupMenu BA;
    private javax.swing.JMenuItem BaQuitar;
    private javax.swing.JPopupMenu LI;
    private javax.swing.JMenuItem LiQuitar;
    private javax.swing.JPopupMenu Menu;
    private javax.swing.JPopupMenu OC;
    private javax.swing.JMenuItem OcQuitar;
    private javax.swing.JPopupMenu RE;
    private javax.swing.JMenuItem ReQuitar;
    private javax.swing.JPopupMenu VE;
    private javax.swing.JMenuItem VeQuitar;
    private javax.swing.JMenuItem btnADexcel;
    private javax.swing.JMenuItem btnADpdf;
    private javax.swing.JMenuItem btnAFexcel;
    private javax.swing.JMenuItem btnAFpdf;
    private javax.swing.JMenuItem btnAHexcel;
    private javax.swing.JMenuItem btnAHpdf;
    private javax.swing.JMenuItem btnAPexcel;
    private javax.swing.JMenuItem btnAPpdf;
    private javax.swing.JButton btnAd;
    private javax.swing.JMenuItem btnAdmision;
    private javax.swing.JButton btnAf;
    private javax.swing.JMenuItem btnAfiliacion;
    private javax.swing.JButton btnAh;
    private javax.swing.JMenuItem btnAhorro;
    private javax.swing.JButton btnAp;
    private javax.swing.JMenuItem btnAportacion;
    private javax.swing.JMenuItem btnBAexcel;
    private javax.swing.JMenuItem btnBApdf;
    private javax.swing.JButton btnBa;
    private javax.swing.JMenuItem btnBazar;
    private javax.swing.JMenu btnExcel;
    private javax.swing.JMenuItem btnLIexcel;
    private javax.swing.JMenuItem btnLIpdf;
    private javax.swing.JButton btnLi;
    private javax.swing.JMenuItem btnLibros;
    private javax.swing.JMenuItem btnOCexcel;
    private javax.swing.JMenuItem btnOCpdf;
    private javax.swing.JButton btnOc;
    private javax.swing.JMenuItem btnOcacional;
    private javax.swing.JMenu btnPDF;
    private javax.swing.JButton btnRe;
    private javax.swing.JMenuItem btnRegistro;
    private javax.swing.JMenuItem btnVEexcel;
    private javax.swing.JMenuItem btnVEpdf;
    private javax.swing.JButton btnVe;
    private javax.swing.JMenuItem btnVentas;
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenuItem popAD;
    private javax.swing.JMenuItem popAF;
    private javax.swing.JMenuItem popAH;
    private javax.swing.JMenuItem popAP;
    private javax.swing.JMenuItem popBA;
    private javax.swing.JMenuItem popLI;
    private javax.swing.JMenuItem popOC;
    private javax.swing.JMenuItem popRE;
    private javax.swing.JMenuItem popVE;
    // End of variables declaration//GEN-END:variables
}
