package net.bigfootslair.CraftBooks;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    public void onEnable() {
        // This is fired when the plugin loads...
        registerCraft();
    }

    private void registerCraft() {
        // Here we make up the actual enchanted book items
        ItemStack silkBook;
        ItemStack effBook;
        ItemStack sharpBook;
        ItemStack fireBook;
        // ItemStack expBottle = new ItemStack(Material.EXP_BOTTLE, 3);

        // And we set the enchantments
        EnchantmentStorageMeta silkMeta = (EnchantmentStorageMeta)(silkBook = new ItemStack(Material.ENCHANTED_BOOK)).getItemMeta();
        EnchantmentStorageMeta effMeta = (EnchantmentStorageMeta)(effBook = new ItemStack(Material.ENCHANTED_BOOK)).getItemMeta();
        EnchantmentStorageMeta sharpMeta = (EnchantmentStorageMeta)(sharpBook = new ItemStack(Material.ENCHANTED_BOOK)).getItemMeta();
        EnchantmentStorageMeta fireMeta = (EnchantmentStorageMeta)(fireBook = new ItemStack(Material.ENCHANTED_BOOK)).getItemMeta();

        silkMeta.addStoredEnchant(Enchantment.SILK_TOUCH, 1, false);
        effMeta.addStoredEnchant(Enchantment.DIG_SPEED, 5, false);
        sharpMeta.addStoredEnchant(Enchantment.DAMAGE_ALL, 5, false);
        fireMeta.addStoredEnchant(Enchantment.FIRE_ASPECT, 2, false);

        silkBook.setItemMeta(silkMeta);
        effBook.setItemMeta(effMeta);
        sharpBook.setItemMeta(sharpMeta);
        fireBook.setItemMeta(fireMeta);

        // Now we make the recipes
        ShapelessRecipe craftSilk = new ShapelessRecipe(silkBook);
        ShapelessRecipe craftEff = new ShapelessRecipe(effBook);
        ShapelessRecipe craftSharp = new ShapelessRecipe(sharpBook);
        ShapelessRecipe craftFire = new ShapelessRecipe(fireBook);

        craftSilk.addIngredient(Material.BOOK);
        craftSilk.addIngredient(Material.EXP_BOTTLE);
        craftSilk.addIngredient(Material.WOOL);

        craftEff.addIngredient(Material.BOOK);
        craftEff.addIngredient(Material.EXP_BOTTLE);
        craftEff.addIngredient(Material.SUGAR);

        craftSharp.addIngredient(Material.BOOK);
        craftSharp.addIngredient(Material.EXP_BOTTLE);
        craftSharp.addIngredient(Material.FLINT);

        craftFire.addIngredient(Material.BOOK);
        craftFire.addIngredient(Material.EXP_BOTTLE);
        craftFire.addIngredient(Material.BLAZE_POWDER);

        // Now we tell the recipe about the recipes
        Bukkit.getServer().addRecipe(craftSilk);
        Bukkit.getServer().addRecipe(craftEff);
        Bukkit.getServer().addRecipe(craftSharp);
        Bukkit.getServer().addRecipe(craftFire);
    }
}
