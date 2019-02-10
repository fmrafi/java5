/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package training;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

/**
 *
 * @author Tanvir
 */
public class FormatNumbers {

    static public void displayNumber(Locale currentLocale) {

        Integer quantity = new Integer(123456);
        Double amount = new Double(345987.246);
        NumberFormat numberFormatter;
        String quantityOut;
        String amountOut;

        numberFormatter = NumberFormat.getNumberInstance(currentLocale);
        quantityOut = numberFormatter.format(quantity);
        amountOut = numberFormatter.format(amount);
        System.out.println(quantityOut + "   " + currentLocale.toString());
        System.out.println(amountOut + "   " + currentLocale.toString());

        DecimalFormatSymbols unusualSymbols = new DecimalFormatSymbols(currentLocale);
        unusualSymbols.setDecimalSeparator('|');
        unusualSymbols.setGroupingSeparator('^');

        String strange = "#,##0.###";
        DecimalFormat weirdFormatter = new DecimalFormat(strange, unusualSymbols);
        weirdFormatter.setGroupingSize(4);

        String bizarre = weirdFormatter.format(12345.678);
        System.out.println(bizarre);
    }

    static public void displayCurrency(Locale currentLocale) {

        Double currencyAmount = new Double(9876543.21);
        Currency currentCurrency = Currency.getInstance(currentLocale);
        NumberFormat currencyFormatter =
                NumberFormat.getCurrencyInstance(currentLocale);

        System.out.println(
                currentLocale.getDisplayName() + ", "
                + currentCurrency.getCurrencyCode() + ": "
                + currencyFormatter.format(currencyAmount));
    }

    public static void main(String[] args) {
        displayNumber(new Locale("en", "US"));
        displayNumber(new Locale("fr", "FR"));
        displayNumber(new Locale("de", "DE"));
        displayNumber(new Locale("bn", "BD"));

        displayCurrency(new Locale("en", "US"));
        displayCurrency(new Locale("fr", "FR"));
        displayCurrency(new Locale("de", "DE"));
        displayCurrency(new Locale("bn", "BD"));
    }
}
