package au.com.ionprogramming.ld34;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Align;

public class SpeechBubble {

    protected BitmapFont font;
    protected GlyphLayout glyph;
    protected String text;
    protected float x;
    protected float y;
    protected float width;
    protected float height;
    protected float border = 6f;
    protected Color textCol;
    protected Color boxCol;
    protected boolean center;

    public int getClickedIndex(int xClick, int yClick){
        yClick = Gdx.graphics.getHeight() - yClick;
        if(xClick > x && xClick < x + width) {
            if(yClick > y - height && yClick < y) {
                String[] things = text.split("\n");
                String full = things[0];
                int pos = 0;
                for (int n = 0; n < things.length; n++) {
                    if(n > 0){
                        full += "\n" + things[n];
                    }
                    glyph.setText(font, full, 0, full.length(), textCol, width, center? Align.center : Align.left, true, null);
                    pos += glyph.height;
                    if(yClick > y - pos){
                        glyph.setText(font, text, 0, text.length(), textCol, width, center? Align.center : Align.left, true, null);
                        return n;
                    }
                }
            }
        }
        return -1;
    }

    public SpeechBubble(String text, float width){
        center = false;
        textCol = Color.SALMON;
        boxCol = new Color(0f, 0f, 0f, 0.5f);
        font = new BitmapFont();
        glyph = new GlyphLayout();
        font.setUseIntegerPositions(false);
        font.getData().setScale(1f, 1f);
        this.text = text;
        this.width = width;
        glyph.setText(font, text, 0, text.length(), textCol, width, Align.left, true, null);
        height = glyph.height;
    }

    public SpeechBubble(String text, float width, Color textCol, Color boxCol){
        center = false;
        this.textCol = textCol;
        this.boxCol = boxCol;
        font = new BitmapFont();
        glyph = new GlyphLayout();
        font.setUseIntegerPositions(false);
        this.text = text;
        this.width = width;
        glyph.setText(font, text, 0, text.length(), textCol, width, Align.left, true, null);
        height = glyph.height;
    }

    public SpeechBubble(String text, float width, Color textCol, Color boxCol, float scale){
        center = false;
        this.textCol = textCol;
        this.boxCol = boxCol;
//        font = new BitmapFont(new FileHandle("arial=15.fnt"), new FileHandle("arial-15.png"), false);

        font = new BitmapFont();
        glyph = new GlyphLayout();
        font.getData().setScale(scale, scale);
        font.setUseIntegerPositions(false);
        this.text = text;
        this.width = width;
        glyph.setText(font, text, 0, text.length(), textCol, width, Align.left, true, null);
        height = glyph.height;
    }

    public SpeechBubble(String text, float width, Color textCol, Color boxCol, float scale, boolean centered){
        center = centered;
        this.textCol = textCol;
        this.boxCol = boxCol;
//        font = new BitmapFont(new FileHandle("arial=15.fnt"), new FileHandle("arial-15.png"), false);

        font = new BitmapFont();
        glyph = new GlyphLayout();
        font.getData().setScale(scale, scale);
        font.setUseIntegerPositions(false);
        this.text = text;
        this.width = width;
        glyph.setText(font, text, 0, text.length(), textCol, width, center? Align.center : Align.left, true, null);
        height = glyph.height;
    }

    public void render(SpriteBatch batch, ShapeRenderer r, float x, float y){
        this.x = x;
        this.y = y;
        batch.end();
        Gdx.gl.glEnable(GL20.GL_BLEND);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        r.begin(ShapeRenderer.ShapeType.Filled);
            r.setColor(boxCol);
            r.rect(x - border, y - height, width + border * 2, height);
            r.rect(x, y - border - height, width, border);
            r.rect(x, y, width, border);
            r.arc(x, y, border, 90, 90);
            r.arc(x, y - height, border, 180, 90);
            r.arc(x + width, y, border, 0, 90);
            r.arc(x + width, y - height, border, 270, 90);
        r.end();
        Gdx.gl.glDisable(GL20.GL_BLEND);
        batch.begin();
            font.draw(batch, glyph, x, y);
    }

    public void renderWithPoint(SpriteBatch batch, ShapeRenderer r, float x, float y){
        this.x = x;
        this.y = y;
        batch.end();
        Gdx.gl.glEnable(GL20.GL_BLEND);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        r.begin(ShapeRenderer.ShapeType.Filled);
        r.setColor(boxCol);
        r.rect(x - border, y - height, width + border * 2, height);
        r.rect(x, y - border - height, width, border);
        r.rect(x, y, width, border);
        r.arc(x, y, border, 90, 90);
        r.arc(x, y - height, border, 180, 90);
        r.arc(x + width, y, border, 0, 90);
        r.arc(x + width, y - height, border, 270, 90);
        r.triangle(x + width/2 - border, y + border, x + width/2, y + 2*border, x + width/2 + border, y + border);
        r.end();
        Gdx.gl.glDisable(GL20.GL_BLEND);
        batch.begin();
        font.draw(batch, glyph, x, y);
    }

    public void renderText(SpriteBatch batch, float x, float y){
        this.x = x;
        this.y = y;
        font.draw(batch, glyph, x, y);
    }
}
