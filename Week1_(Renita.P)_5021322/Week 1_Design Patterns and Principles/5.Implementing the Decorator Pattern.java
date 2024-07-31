interface Notifier {
    void send();
}

class EmailNotifier implements Notifier {
    @Override
    public void send() {
        System.out.println("Sending email notification.");
    }
}

abstract class NotifierDecorator implements Notifier {
    protected Notifier wrapped;

    public NotifierDecorator(Notifier wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public void send() {
        wrapped.send();
    }
}

class SMSNotifierDecorator extends NotifierDecorator {
    public SMSNotifierDecorator(Notifier wrapped) {
        super(wrapped);
    }

    @Override
    public void send() {
        super.send();
        System.out.println("Sending SMS notification.");
    }
}

class SlackNotifierDecorator extends NotifierDecorator {
    public SlackNotifierDecorator(Notifier wrapped) {
        super(wrapped);
    }

    @Override
    public void send() {
        super.send();
        System.out.println("Sending Slack notification.");
    }
}

public class DecoratorPatternTest {
    public static void main(String[] args) {
        Notifier emailNotifier = new EmailNotifier();
        Notifier smsNotifier = new SMSNotifierDecorator(emailNotifier);
        Notifier slackNotifier = new SlackNotifierDecorator(smsNotifier);

        slackNotifier.send();
    }
}
