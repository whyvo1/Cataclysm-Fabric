package com.github.l_ender.lionfishapi.client.screen;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.MultilineText;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.screen.ScreenTexts;
import net.minecraft.text.ClickEvent;
import net.minecraft.text.MutableText;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import org.jetbrains.annotations.Nullable;

public class OptifineWarningScreen extends Screen {

	private final Screen lastScreen;
	private int ticksUntilEnable = 20 * 8;
	private MultilineText message = MultilineText.EMPTY;
	private MultilineText xenonsuggestions = MultilineText.EMPTY;
	private MultilineText oculussuggestions = MultilineText.EMPTY;
	private static final Text text = Text.translatable("gui.lionfishapi.optifine.message");
	private static final MutableText xenonurl = Text.translatable("gui.lionfishapi.optifine.xenonsuggestions").styled(style -> style.withColor(Formatting.GREEN).withFormatting(Formatting.UNDERLINE).withClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://modrinth.com/mod/xenon-forge")));
	private static final MutableText oculusurl = Text.translatable("gui.lionfishapi.optifine.oculussuggestions").styled(style -> style.withColor(Formatting.GREEN).withFormatting(Formatting.UNDERLINE).withClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://modrinth.com/mod/oculus")));
	private ButtonWidget exitButton;

	public OptifineWarningScreen(Screen screen) {
		super(Text.translatable("gui.lionfishapi.optifine.title"));
		this.lastScreen = screen;
	}

	@Override
	public Text getNarratedTitle() {
		return ScreenTexts.joinSentences(super.getNarratedTitle(), text);
	}

	@Override
	protected void init() {
		super.init();
		this.exitButton = this.addDrawableChild(ButtonWidget.builder(ScreenTexts.PROCEED, (pressed) -> MinecraftClient.getInstance().setScreen(this.lastScreen)).dimensions(this.width / 2 - 75, this.height * 3 / 4, 150, 20).build());
		this.exitButton.active = true;
		this.message = MultilineText.create(this.textRenderer, text, this.width - 25);
		this.xenonsuggestions = MultilineText.create(this.textRenderer, xenonurl, this.width - 35);
		this.oculussuggestions = MultilineText.create(this.textRenderer, oculusurl, this.width - 45);
	}

	@Override
	public void render(DrawContext graphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(graphics, mouseX, mouseY, partialTicks);
		graphics.drawCenteredTextWithShadow(this.textRenderer, this.title, this.width / 2, 30, 16777215);
		this.message.drawCenterWithShadow(graphics, this.width / 2, 70);
		this.xenonsuggestions.drawCenterWithShadow(graphics, this.width / 2, 120);
		this.oculussuggestions.drawCenterWithShadow(graphics, this.width / 2, 160);
		super.render(graphics, mouseX, mouseY, partialTicks);

		this.exitButton.render(graphics, mouseX, mouseY, partialTicks);
	}

	@Override
	public void tick() {
		super.tick();
		if (--this.ticksUntilEnable <= 0) {
			this.exitButton.active = true;
		}
	}

	@Override
	public boolean shouldCloseOnEsc() {
		return this.ticksUntilEnable <= 0;
	}

	@Override
	public void close() {
		MinecraftClient.getInstance().setScreen(this.lastScreen);
	}

	@Override
	public boolean mouseClicked(double pMouseX, double pMouseY, int pButton) {
		if (pMouseY > 120 && pMouseY < 130) {
			Style style = this.getClickedComponentStyleAt((int) pMouseX,xenonurl);
			if (style != null && style.getClickEvent() != null && style.getClickEvent().getAction() == ClickEvent.Action.OPEN_URL) {
				this.handleTextClick(style);
				return false;
			}
		}

		if (pMouseY > 160 && pMouseY < 170) {
			Style style = this.getClickedComponentStyleAt((int) pMouseX,oculusurl);
			if (style != null && style.getClickEvent() != null && style.getClickEvent().getAction() == ClickEvent.Action.OPEN_URL) {
				this.handleTextClick(style);
				return false;
			}
		}

		return super.mouseClicked(pMouseX, pMouseY, pButton);
	}

	@Nullable
	private Style getClickedComponentStyleAt(int xPos,MutableText url) {
		int wid = MinecraftClient.getInstance().textRenderer.getWidth(url);
		int left = this.width / 2 - wid / 2;
		int right = this.width / 2 + wid / 2;
		return xPos >= left && xPos <= right ? MinecraftClient.getInstance().textRenderer.getTextHandler().getStyleAt(url, xPos - left) : null;
	}

}
