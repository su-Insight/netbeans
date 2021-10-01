/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.netbeans.modules.java.hints.jdk;

import java.awt.Color;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.util.Exceptions;
import org.openide.util.NbBundle;
import org.openide.windows.TopComponent;
import org.openide.util.NbBundle.Messages;
import org.openide.windows.Mode;
import org.openide.windows.WindowManager;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(
        dtd = "-//org.netbeans.modules.java.hints.jdk//CheckRegex//EN",
        autostore = false
)
@TopComponent.Description(
        preferredID = "CheckRegexTopComponent",
        persistenceType = TopComponent.PERSISTENCE_ALWAYS
)
@TopComponent.Registration(mode = "output", openAtStartup = false, position = 13000)
@ActionID(category = "Window", id = "org.netbeans.modules.java.hints.jdk.CheckRegexTopComponent")
@ActionReferences({
    @ActionReference(name = "Check Regex", path = "Menu/Window", position = 950),
    @ActionReference(path = "Shortcuts", name = "C-8")})
@TopComponent.OpenActionRegistration(
        displayName = "#CTL_CheckRegexAction",
        preferredID = "CheckRegexTopComponent"
)
@Messages({
    "CTL_CheckRegexAction=Check Regex",
    "CTL_CheckRegexTopComponent=Check Regular Expression",
    "HINT_CheckRegexTopComponent=This is a Check Regex window"
})
public final class CheckRegexTopComponent extends TopComponent {

    private static CheckRegexTopComponent instance;
    private static final String PREFERRED_ID = "CheckRegexTopComponent";
    private static boolean isStrictMatch;

    public CheckRegexTopComponent() {
        initComponents();
        setName(Bundle.CTL_CheckRegexTopComponent());
        setToolTipText(Bundle.HINT_CheckRegexTopComponent());
        isStrictMatch = false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        regexLabel = new javax.swing.JLabel();
        regexScrollPane = new javax.swing.JScrollPane();
        regexTextArea = new javax.swing.JTextArea();
        exampleLabel = new javax.swing.JLabel();
        exampleLayeredPane = new javax.swing.JLayeredPane();
        iconLabel = new javax.swing.JLabel();
        exampleScrollPane = new javax.swing.JScrollPane();
        exampleTextArea = new javax.swing.JTextArea();
        strictCheckBox = new javax.swing.JCheckBox();
        errorLabel = new javax.swing.JLabel();

        org.openide.awt.Mnemonics.setLocalizedText(regexLabel, org.openide.util.NbBundle.getMessage(CheckRegexTopComponent.class, "CheckRegexTopComponent.regexLabel.text")); // NOI18N

        regexScrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        regexScrollPane.setPreferredSize(new java.awt.Dimension(164, 74));

        regexTextArea.setColumns(20);
        regexTextArea.setRows(5);
        regexTextArea.setFocusAccelerator('g');
        regexTextArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                regexTextAreaKeyReleased(evt);
            }
        });
        regexScrollPane.setViewportView(regexTextArea);

        org.openide.awt.Mnemonics.setLocalizedText(exampleLabel, org.openide.util.NbBundle.getMessage(CheckRegexTopComponent.class, "CheckRegexTopComponent.exampleLabel.text")); // NOI18N

        exampleScrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        exampleScrollPane.setOpaque(false);

        exampleTextArea.setColumns(20);
        exampleTextArea.setRows(5);
        exampleTextArea.setFocusAccelerator('x');
        exampleTextArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                exampleTextAreaKeyReleased(evt);
            }
        });
        exampleScrollPane.setViewportView(exampleTextArea);

        org.openide.awt.Mnemonics.setLocalizedText(strictCheckBox, org.openide.util.NbBundle.getMessage(CheckRegexTopComponent.class, "CheckRegexTopComponent.strictCheckBox.text")); // NOI18N
        strictCheckBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                strictCheckBoxItemStateChanged(evt);
            }
        });

        exampleLayeredPane.setLayer(iconLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        exampleLayeredPane.setLayer(exampleScrollPane, javax.swing.JLayeredPane.DEFAULT_LAYER);
        exampleLayeredPane.setLayer(strictCheckBox, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout exampleLayeredPaneLayout = new javax.swing.GroupLayout(exampleLayeredPane);
        exampleLayeredPane.setLayout(exampleLayeredPaneLayout);
        exampleLayeredPaneLayout.setHorizontalGroup(
            exampleLayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, exampleLayeredPaneLayout.createSequentialGroup()
                .addContainerGap(297, Short.MAX_VALUE)
                .addComponent(iconLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(strictCheckBox))
            .addGroup(exampleLayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(exampleLayeredPaneLayout.createSequentialGroup()
                    .addComponent(exampleScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 15, Short.MAX_VALUE)))
        );
        exampleLayeredPaneLayout.setVerticalGroup(
            exampleLayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(exampleLayeredPaneLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(exampleLayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(strictCheckBox)
                    .addComponent(iconLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(exampleLayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(exampleLayeredPaneLayout.createSequentialGroup()
                    .addComponent(exampleScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 6, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(regexLabel)
                    .addComponent(exampleLabel)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(regexScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(errorLabel))
                    .addComponent(exampleLayeredPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(266, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(regexLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(regexScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(errorLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(exampleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exampleLayeredPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void exampleTextAreaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_exampleTextAreaKeyReleased
        if (exampleTextArea.getSelectedText() == null) {
            matchPattern();
        }
    }//GEN-LAST:event_exampleTextAreaKeyReleased

    private void regexTextAreaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_regexTextAreaKeyReleased
        matchPattern();
    }//GEN-LAST:event_regexTextAreaKeyReleased

    private void strictCheckBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_strictCheckBoxItemStateChanged
        isStrictMatch = !isStrictMatch;
        matchPattern();
    }//GEN-LAST:event_strictCheckBoxItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel errorLabel;
    private javax.swing.JLabel exampleLabel;
    private javax.swing.JLayeredPane exampleLayeredPane;
    private javax.swing.JScrollPane exampleScrollPane;
    private javax.swing.JTextArea exampleTextArea;
    private javax.swing.JLabel iconLabel;
    private javax.swing.JLabel regexLabel;
    private javax.swing.JScrollPane regexScrollPane;
    private javax.swing.JTextArea regexTextArea;
    private javax.swing.JCheckBox strictCheckBox;
    // End of variables declaration//GEN-END:variables
    @Override
    public void componentOpened() {
        // TODO add custom code on component opening
    }

    @Override
    public void componentClosed() {
        // TODO add custom code on component closing
    }

    void writeProperties(java.util.Properties p) {
        // better to version settings since initial version as advocated at
        // http://wiki.apidesign.org/wiki/PropertyFiles
        p.setProperty("version", "1.0");    // NOI18N
        // TODO store your settings
    }

    void readProperties(java.util.Properties p) {
        String version = p.getProperty("version");  // NOI18N
        // TODO read your settings according to their version
    }

    public static synchronized CheckRegexTopComponent getDefault() {
        if (instance == null) {
            instance = new CheckRegexTopComponent();
        }
        Mode outputMode = WindowManager.getDefault().findMode("output");    // NOI18N
        if (outputMode != null) {
            outputMode.dockInto(instance);
        }
        return instance;
    }

    public static synchronized CheckRegexTopComponent findInstance() {
        TopComponent win = WindowManager.getDefault().findTopComponent(PREFERRED_ID);
        if (win == null) {
            Logger.getLogger(CheckRegexTopComponent.class.getName()).warning(
                    "Cannot find " + PREFERRED_ID + " component. It will not be located properly in the window system.");   // NOI18N
            return getDefault();
        }
        if (win instanceof CheckRegexTopComponent) {
            return (CheckRegexTopComponent) win;
        }
        Logger.getLogger(CheckRegexTopComponent.class.getName()).warning(
                "There seem to be multiple components with the '" + PREFERRED_ID
                + "' ID. That is a potential source of errors and unexpected behavior.");   // NOI18N
        return getDefault();
    }

    void setData(String origString) {
        regexTextArea.setText(origString);
        matchPattern();
    }

    @NbBundle.Messages({
        "CheckRegexTopComponent.tooltip.match.regex=The Example Matches the Regular Expression",
        "CheckRegexTopComponent.tooltip.need.more.input=Need more input to match",
        "CheckRegexTopComponent.tooltip.not.match=The example does not match the Regular Expression.",
        "# {0} - matchCount",
        "CheckRegexTopComponent.tooltop.sub.match={0} substring(s) match the Regular Expression",
        "# {0} - invalidRegex",
        "CheckRegexTopComponent.label.error=Invalid regular expression: {0}"
    })
    private void matchPattern() {

        Highlighter highlighter = exampleTextArea.getHighlighter();
        highlighter.removeAllHighlights();

        errorLabel.setText("");
        iconLabel.setIcon(null);

        if (regexTextArea.getText().length() == 0 || exampleTextArea.getText().length() == 0) {
            return;
        }
        Pattern p;
        try {
            p = Pattern.compile(regexTextArea.getText());
        } catch (PatternSyntaxException pse) {
            errorLabel.setText(Bundle.CheckRegexTopComponent_label_error(pse.getDescription()));
            return;
        }
        Matcher m = p.matcher(exampleTextArea.getText());

        if (m.matches()) {
            iconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/netbeans/modules/java/hints/resources/match.png"))); // NOI18N
            exampleTextArea.setToolTipText(Bundle.CheckRegexTopComponent_tooltip_match_regex());
        } else if (m.hitEnd()) {
            iconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/netbeans/modules/java/hints/resources/half-match.png"))); // NOI18N
            exampleTextArea.setToolTipText(Bundle.CheckRegexTopComponent_tooltip_need_more_input());
        } else if (isStrictMatch) {
            iconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/netbeans/modules/java/hints/resources/no-match.png"))); // NOI18N
            exampleTextArea.setToolTipText(Bundle.CheckRegexTopComponent_tooltip_not_match());
        } else {
            m.reset();
            long count = 0;
            try {
                while (m.find()) {
                    int start = m.start();
                    int end = m.end();
                    DefaultHighlighter.DefaultHighlightPainter defaultHighlightPainter = new DefaultHighlighter.DefaultHighlightPainter(Color.GREEN);
                    highlighter.addHighlight(start, end, defaultHighlightPainter);
                    count++;
                }
                if (count > 0) {
                    iconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/netbeans/modules/java/hints/resources/match.png"))); // NOI18N
                    exampleTextArea.setToolTipText(Bundle.CheckRegexTopComponent_tooltop_sub_match(count));
                } else {
                    iconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/netbeans/modules/java/hints/resources/no-match.png"))); // NOI18N
                    exampleTextArea.setToolTipText(Bundle.CheckRegexTopComponent_tooltip_not_match());
                }
            } catch (BadLocationException e) {
                Exceptions.printStackTrace(e);
            }
        }
    }
}