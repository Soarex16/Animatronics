package animatronica.api.energy;

import java.util.UUID;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class TileEntityEnergyGeneric extends TileEntity implements ITERequiresEntropy, IInventory, ISidedInventory {
	
	int entropy;
	int maxEntropy = 1000;
	UUID uuid = UUID.randomUUID();
	
	private ItemStack[] items = new ItemStack[1];
	
	@Override
	public int getEntropy() {
		return entropy;
	}

	@Override
	public int getMaxEntropy() {
		return maxEntropy;
	}

	@Override
	public boolean setEntropy(int i) {
		entropy = i;
		return true;
	}

	@Override
	public boolean setMaxEntropy(float f) {
		maxEntropy = (int)f;
		return true;
	}

	@Override
	public UUID getUUID() {
		return uuid;
	}

	@Override
	public int getSizeInventory() {
		// TODO Auto-generated method stub
		return this.items.length;
	}

	@Override
	public ItemStack getStackInSlot(int par1) {
		// TODO Auto-generated method stub
		return this.items[par1];
	}

	@Override
	public ItemStack decrStackSize(int par1, int par2) {
        if (this.items[par1] != null)
        {
            ItemStack itemstack;

            if (this.items[par1].stackSize <= par2)
            {
                itemstack = this.items[par1];
                this.items[par1] = null;
                return itemstack;
            }
            else
            {
                itemstack = this.items[par1].splitStack(par2);

                if (this.items[par1].stackSize == 0)
                {
                    this.items[par1] = null;
                }

                return itemstack;
            }
        }
        else
        {
            return null;
        }
	}

	@Override
    public ItemStack getStackInSlotOnClosing(int par1)
    {
        if (this.items[par1] != null)
        {
            ItemStack itemstack = this.items[par1];
            this.items[par1] = null;
            return itemstack;
        }
        else
        {
            return null;
        }
    }


    @Override
    public void setInventorySlotContents(int par1, ItemStack par2ItemStack)
    {
        this.items[par1] = par2ItemStack;

        if (par2ItemStack != null && par2ItemStack.stackSize > this.getInventoryStackLimit())
        {
            par2ItemStack.stackSize = this.getInventoryStackLimit();
        }
    }
    

	@Override
	public String getInventoryName() {
		return "animatronica.container.generic";
	}

	@Override
	public boolean hasCustomInventoryName() {
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		return this.worldObj.getTileEntity(xCoord, yCoord, zCoord) == this && player.dimension == this.worldObj.provider.dimensionId;
	}

	@Override
	public void openInventory() {
		
	}

	@Override
	public void closeInventory() {
		
	}

	@Override
	public boolean isItemValidForSlot(int p_94041_1_, ItemStack p_94041_2_) {
			return true;
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int side) {
		if(this.getSizeInventory() > 0)
		{
			if(side == 1)
				return new int[]{0};
			else
			{
				int[] retInt = new int[this.getSizeInventory()-1];
				for(int i = 1; i < this.getSizeInventory(); ++i)
				{
					retInt[i-1] = i;
				}
				return retInt;
			}
		}
		else
			return new int[]{};
	}

	@Override
	public boolean canInsertItem(int p_102007_1_, ItemStack p_102007_2_, int p_102007_3_) {
		return this.isItemValidForSlot(p_102007_1_, p_102007_2_);
	}

	@Override
	public boolean canExtractItem(int p_102008_1_, ItemStack p_102008_2_, int p_102008_3_) {
		return true;
	}
	
}
