import java.util.ArrayList;
import java.util.stream.IntStream;

class Intervals {
    int buy, sell;
}

public class StockBuySell {
    void stockBuySell(int[] price, int n)
    {
        if (n == 1)
            return;

        int count = 0;

        ArrayList<Intervals> sol = new ArrayList<Intervals>();

        int i = 0;
        while (i < n - 1) {
            while ((i < n - 1) && (price[i + 1] <= price[i]))
                i++;

            if (i == n - 1)
                break;

            Intervals e = new Intervals();
            e.buy = i++;

            while ((i < n) && (price[i] >= price[i - 1]))
                i++;

            e.sell = i - 1;
            sol.add(e);

            count++;
        }

        if (count == 0)
            System.out.println("There is no day when buying the stock "
                    + "will make profit");
        else
            IntStream.range(0, count).mapToObj(j -> "Buy on day: " + sol.get(j).buy
                    + "        "
                    + "Sell on day : " + sol.get(j).sell).forEachOrdered(System.out::println);

    }

    public static void main(String[] args)
    {
        StockBuySell stock = new StockBuySell();

        int[] price = { 100, 180, 260, 310, 40, 535, 695 };
        int n = price.length;

        stock.stockBuySell(price, n);
    }
}