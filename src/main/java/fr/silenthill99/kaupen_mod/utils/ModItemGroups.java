package fr.silenthill99.kaupen_mod.utils;

import fr.silenthill99.kaupen_mod.init.ModItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public enum ModItemGroups {
     TUTORIAL_GROUP(new ItemGroup("tutorial_mod_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.AMETHYST.get());
        }
     });
     private final ItemGroup group;

     ModItemGroups(ItemGroup group) {
         this.group = group;
     }

     public ItemGroup getGroup() {
         return this.group;
     }
}
