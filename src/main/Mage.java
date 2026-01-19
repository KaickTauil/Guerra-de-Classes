
public class Mage extends Player {
    
    public Mage(String name) {
        super(name, 100);
        addResource(new Mana(100));
    }

    @Override
    public void attack(Player target) {
        Mana mana = getResource(Mana.class);
        int damage = target.receiveDamage(50);
        System.out.println(this.getName() + " Atacou " + target.getName() + ", causando " + damage + " pontos de dano.");

         // Verificação pós-ataque, só para testes
        if (target.isAlive()) {
            System.out.println(
                target.getName() + " continua vivo (" +
                target.getCurrentHP() + "/" + target.getMaxHP() + " PV)."
            );
        } else {
        System.out.println(target.getName() + " Morreu!");
        }
    }
}