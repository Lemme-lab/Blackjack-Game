# Blackjack-Game SEN
### Simple Project to get into a new Java IDE
---
There are only a few simple methods and logics in the game. The game is just checking for default rules of Blackjack without considering Double or Split as well as the Ace. Most of the time used in the project went into learning and debugging the new IDE.

#### 1.Creating the dealer and player Hands:

```Java
    public static int player_hand(){
        Random rnd = new Random();
        int low = 2;
        int high = 11;
        int result = rnd.nextInt(high-low) + low;
        return result;
    }

    public static int dealer_hand(){
        Random rnd = new Random();
        int low = 2;
        int high = 11;
        int result = rnd.nextInt(high-low) + low;
        return result;
            }
```

#### 2.Loading in the first Hand
We load in 2 cards for the dealer and player each. This will be used later in the GUI.
```Java
int first_hand =  player_hand();
        int second_hand = player_hand();

        int first_hand_dealer =  dealer_hand();
        int second_hand_dealer = dealer_hand();

        int wert_Player = first_hand + second_hand;
        int wert_Dealer = first_hand_dealer + second_hand_dealer;

```

####    2.Checking for HIT
We check the card count and accordingly. We add a card/stay and print out the winner/loser/draw.
```Java
        if(wert_Player < 21) {
            wert_Player = Integer.parseInt(textField_1.getText())+player_hand();
            textField_1.setText(wert_Player+"");
        }
        
        if(wert_Player > 21) {
            textField.setText(wert_Dealer+" " + "'WIN");
            textField_1.setText(wert_Player+" " + "'BUST");
        }
        else {

            if(Integer.parseInt(textField.getText()) >= 17) {
                wert_Dealer = Integer.parseInt(textField.getText());
                textField.setText(wert_Dealer+"");
            }
            else {
             wert_Dealer = Integer.parseInt(textField.getText())+dealer_hand();
             textField.setText(wert_Dealer+"");
                if(wert_Dealer > 21) {
                    textField.setText(wert_Dealer+" " + "'Bust");
                    textField_1.setText(wert_Player+" " + "'WIN");
                }
            }
        }
```
####    2.Checking for Stay
Here we only have to check who has the highest Card count. Then it gives out the winner/loser/draw. 
```Java
if(wert_Dealer<17){
            wert_Dealer += dealer_hand();
        }
        if(wert_Player > wert_Dealer) {
            textField_1.setText(wert_Player + " 'WIN'");
        }
        else if(wert_Player < wert_Dealer) {
            textField_1.setText(wert_Player + " 'LOSE'");
        }
        else if(wert_Player == wert_Dealer) {
            textField_1.setText(wert_Player + " 'DRAW'");
        }
```

####  3.GUI
First we load in the images.
```Java
public Blackjack() throws IOException{
        initComponents();BufferedImage Ass = ImageIO.read(new File("src/Ass.png"));
        BufferedImage Zwei = ImageIO.read(new File("src/Zwei.png"));
        BufferedImage Drei = ImageIO.read(new File("src/Drei.png")); ......
```
Then we display them according to the Hands.
```Java
switch(first_hand_dealer){
            case 2:
                label2 = new JLabel(new ImageIcon(Zwei.getScaledInstance(200, 150, Image.SCALE_FAST)));
                break;
            case 3:
                label2 = new JLabel(new ImageIcon(Drei.getScaledInstance(200, 150, Image.SCALE_FAST)));
                break;........
```
