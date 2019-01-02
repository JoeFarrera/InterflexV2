package es.sysmap.interflex.view;

import javax.swing.text.JTextComponent;
import oracle.jbo.domain.Number;
import javax.swing.JTextField;

public class PesadaBascula 
{
  public static final int MINPESADESMLD = 30;
  private JTextField mPesini;
  private JTextField mPesfin;
  private Number pesInicial = null;
  private int numPesades;
  boolean bMld;
  
  
  public PesadaBascula(JTextField mPesini, JTextField mPesfin, boolean bMld)
  {
    this.mPesini = mPesini;
    this.mPesfin = mPesfin;
    this.bMld = bMld;
  }
  
  public void novaPesada(String pes)
  {
    try
    {
      Number noupes = (Number)(new Number(pes)).round(2);
      
      if (!noupes.equals((Number)(new Number(0)).round(2)))
      {
        if (mPesini.getText() == null || mPesini.getText().equals(""))
        {
          // Verifiquem que s'ha rebut X vegades seguides el mateix pes (nomes miniload)
          if (bMld)
          {
            if (pesInicial == null)
              pesInicial = noupes;
            if (pesInicial.equals(noupes))
              numPesades++;
            else
              pesInicial = noupes;
          }
          else
            numPesades = MINPESADESMLD;
          if (numPesades >= MINPESADESMLD)
          {
            mPesini.setText(pes);
            mPesini.postActionEvent();
          }
        }
        else
        {
          if (mPesfin.getText() == null || mPesfin.getText().equals(""))
          {
            mPesfin.setText(pes);
            mPesfin.postActionEvent();
          }
          else
          {
            Number pesfin = (Number)(new Number(mPesfin.getText())).round(2);
            if (!pesfin.equals(noupes))
            {
              mPesfin.setText(pes);
              mPesfin.postActionEvent();
            }
          }
        }
      }
    }
    catch(Exception ex){};
  }
}