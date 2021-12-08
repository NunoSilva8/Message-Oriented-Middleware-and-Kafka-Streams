package entities;

import java.sql.Date;


public class Payment {

    private Integer id;
    private Client client;
    private Date date;
    private Currency currency;
    private Long amount;

    public Payment(Integer id, Client client, Currency currency, Long amount, Boolean isDebit) {
        this.id = id;
        this.client = client;
        this.date = new Date(System.currentTimeMillis());
        this.currency = currency;
        this.amount = amount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", client=" + client +
                ", date=" + date +
                ", currency=" + currency +
                ", amount=" + amount +
                '}';
    }
}