package ch05.practice;

import ch05.dataGenerator.TransactionFactory;
import ch05.model.Trader;
import ch05.model.Transaction;

import java.util.List;

import static ch05.tool.PrintTool.print;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

public class TraderAndTransactionPractice {

    private List<Transaction> transactions;

    public TraderAndTransactionPractice(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public void transactionsIn2011OrderByValue() {
        print(
                transactions.stream()
                        .filter(transaction -> transaction.getYear() == 2011)
                        .sorted(comparing(Transaction::getValue))
                        .collect(toList())
        );
    }

    public void traderCities() {
        print(
                transactions.stream()
                        .map(transaction -> transaction.getTrader().getCity())
                        .collect(toSet())
        );
    }

    public void traderFromCambridgeOrderByName() {
        print(
                transactions.stream()
                        .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                        .map(Transaction::getTrader)
                        .distinct()
                        .sorted(comparing(Trader::getName))
                        .collect(toSet())
        );
    }

    public void traderNameOrderByAlphabet() {
        print(
                transactions.stream()
                        .map(transaction -> transaction.getTrader().getName())
                        .distinct()
                        .sorted()
                        .collect(joining())
//                        .reduce("", (s1, s2) -> s1 + s2)
        );
    }

    public void isTraderLiveInMilan() {
        print(
                transactions.stream()
                        .anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"))
        );
    }

    public void transactionValueLiveInCambridge() {
        print(
                transactions.stream()
                        .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                        .map(Transaction::getValue)
                        .collect(toList())
        );
    }

    public void sumTransactionValueLiveInCambridgeUsingIntStream() {
        print(
                transactions.stream()
                        .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                        .mapToInt(Transaction::getValue)
                        .sum()
        );
    }

    public void maxTransactionValue() {
        print(
                transactions.stream()
                        .map(Transaction::getValue)
                        .reduce(Integer::max)
        );
    }

    public void minTransactionValue() {
//        print(
//                transactions.stream()
//                        .reduce((left, right) -> left.getValue() < right.getValue() ? left : right)
//        );
        print(
                transactions.stream()
                        .min(comparing(Transaction::getValue))
        );
    }

    public static void main(String[] args) {
        TraderAndTransactionPractice practice = new TraderAndTransactionPractice(TransactionFactory.createTransactionExample());

        practice.transactionsIn2011OrderByValue();
        practice.traderCities();
        practice.traderFromCambridgeOrderByName();
        practice.traderNameOrderByAlphabet();
        practice.isTraderLiveInMilan();
        practice.transactionValueLiveInCambridge();
        practice.sumTransactionValueLiveInCambridgeUsingIntStream();
        practice.maxTransactionValue();
        practice.minTransactionValue();
    }

}
