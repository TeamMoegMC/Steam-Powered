/*
 * Copyright (c) 2021 TeamMoeg
 *
 * This file is part of Frosted Heart.
 *
 * Frosted Heart is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, version 3.
 *
 * Frosted Heart is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Frosted Heart. If not, see <https://www.gnu.org/licenses/>.
 */

package com.teammoeg.steampowered.client;

import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.particle.IParticleRenderType;
import net.minecraft.client.particle.SpriteTexturedParticle;
import net.minecraft.client.renderer.ActiveRenderInfo;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.math.MathHelper;

public class ParticleBase extends SpriteTexturedParticle {
    protected float originalScale = 1.3F;

    protected ParticleBase(ClientWorld world, double x, double y, double z) {
        super(world, x, y, z);
    }

    public ParticleBase(ClientWorld world, double x, double y, double z, double motionX, double motionY, double motionZ) {
        super(world, x, y, z, motionX, motionY, motionZ);
        this.xd*=1.25;
        this.yd*=1.25;
        this.zd*=1.25;
    }

    public IParticleRenderType getRenderType() {
        return IParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }

    @Override
    public void render(IVertexBuilder worldRendererIn, ActiveRenderInfo entityIn, float pt) {
        float age = (this.age + pt) / lifetime * 32.0F;

        age = MathHelper.clamp(age, 0.0F, 1.0F);
        super.alpha=MathHelper.clamp(1-(this.age + pt) / lifetime, 0.0F, 1.0F);
        super.quadSize = originalScale*(age+this.age*0.01875F);
        super.render(worldRendererIn, entityIn, pt);
    }

    public void tick() {
        super.xo = x;
        super.yo = y;
        super.zo = z;
        if (age >= lifetime)
            super.remove();
        this.age++;
        this.yd -= 0.04D * gravity;
        move(xd,yd, zd);

        if (y == yo) {
            this.xd *= 1.1D;
            this.zd *= 1.1D;
            this.age+=7;
        }
        this.xd *= 0.96D;
        this.yd *= 0.96D;
        this.zd *= 0.96D;

        if (onGround) {
            this.xd *= 0.67D;
            this.zd *= 0.67D;
        }
    }


}
