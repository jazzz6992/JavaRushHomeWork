package com.javarush.test.level32.lesson15.big01.listeners;

import com.javarush.test.level32.lesson15.big01.View;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;

/**
 * Created by vsevolodvisnevskij on 20.04.17.
 */
public class TextEditMenuListener implements MenuListener {

   private View view;

    public TextEditMenuListener(View view) {
        this.view = view;
    }

    @Override
    public void menuSelected(MenuEvent e) {
       JMenu jMenu = (JMenu) e.getSource();
      Component[] components = jMenu.getMenuComponents();
        for (int i = 0; i < components.length; i++) {
            components[i].setEnabled(view.isHtmlTabSelected());
        }
    }

    @Override
    public void menuDeselected(MenuEvent e) {

    }

    @Override
    public void menuCanceled(MenuEvent e) {

    }
}
