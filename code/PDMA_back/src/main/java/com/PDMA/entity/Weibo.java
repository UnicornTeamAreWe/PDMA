package com.PDMA.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Weibo")
@JsonIgnoreProperties(value = {"userId","hibernateLazyInitializer","fieldHandler"})
public class Weibo {
    private Long userId;
    private Long Wb;
    private Long Fans;
    private Long Follow;
    private Long Unclassified;
    private Long Cross_talk;
    private Long Movie;
    private Long Sports;
    private Long Beauty;
    private Long Game;
    private Long Digital;
    private Long Photography;
    private Long Emotion;
    private Long Pet;
    private Long Police;
    private Long Cartoon;
    private Long Star;
    private Long Celebrity;
    private Long Colleague;
    private Long Classmate;

    public Weibo() {}

    public Weibo(Long userId,
            Long Wb,
            Long Fans,
            Long Follow,
            Long Unclassified,
            Long Cross_talk,
            Long Movie,
             Long Sports,
            Long Beauty,
            Long Game,
            Long Digital,
            Long Photography,
            Long Emotion,
            Long Pet,
            Long Police,
            Long Cartoon,
            Long Star,
            Long Celebrity,
            Long Colleague,
            Long Classmate) {
        this.userId = userId;
        this.Wb = Wb;
        this.Fans = Fans;
        this.Follow = Follow;
        this.Unclassified = Unclassified;
        this.Cross_talk = Cross_talk;
        this.Movie = Movie;
        this.Sports = Sports;
        this.Beauty = Beauty;
        this.Game = Game;
        this.Digital = Digital;
        this.Photography = Photography;
        this.Emotion = Emotion;
        this.Pet = Pet;
        this.Police = Police;
        this.Cartoon = Cartoon;
        this.Star = Star;
        this.Celebrity = Celebrity;
        this.Colleague = Colleague;
        this.Classmate = Classmate;
    }

    @Id
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getWb() {
        return Wb;
    }
    public void setWb(Long Wb) {
        this.Wb = Wb;
    }

    public Long getFans() {
        return Fans;
    }
    public void setFans(Long Fans) {
        this.Fans = Fans;
    }

    public Long getFollow() {
        return Follow;
    }
    public void setFollow(Long Follow) {
        this.Follow = Follow;
    }

    public Long getUnclassified() {
        return Unclassified;
    }
    public void setUnclassified(Long Unclassified) {
        this.Unclassified= Unclassified;
    }

    public Long getCross_talk() {
        return Cross_talk;
    }
    public void setCross_talk(Long Cross_talk) {
        this.Cross_talk = Cross_talk;
    }

    public Long getMovie() {
        return Movie;
    }
    public void setMovie(Long Movie) {
        this.Movie = Movie;
    }

    public Long getSports() {
        return Sports;
    }
    public void setSports(Long Sports) {
        this.Sports = Sports;
    }

    public Long getBeauty() {
        return Beauty;
    }
    public void setBeauty(Long Beauty) {
        this.Beauty = Beauty;
    }

    public Long getGame() {
        return Game;
    }
    public void setGame(Long Game) {
        this.Game = Game;
    }

    public Long getDigital() {
        return Digital;
    }
    public void setDigital(Long Digital) {
        this.Digital = Digital;
    }

    public Long getPhotography() {
        return Photography;
    }
    public void setPhotography(Long Photography) {
        this.Photography = Photography;
    }

    public Long getEmotion() {
        return Emotion;
    }
    public void setEmotion(Long Emotion) {
        this.Emotion = Emotion;
    }

    public Long getPet() {
        return Pet;
    }
    public void setPet(Long Pet) {
        this.Pet = Pet;
    }

    public Long getPolice() {
        return Police;
    }
    public void setPolice(Long Police) {
        this.Police = Police;
    }

    public Long getCartoon() {
        return Cartoon;
    }
    public void setCartoon(Long Cartoon) {
        this.Cartoon = Cartoon;
    }

    public Long getStar() {
        return Star;
    }
    public void setStar(Long Star) {
        this.Star = Star;
    }

    public Long getCelebrity() {
        return Celebrity;
    }
    public void setCelebrity(Long Celebrity) {
        this.Celebrity = Celebrity;
    }

    public Long getColleague() {
        return Colleague;
    }
    public void setColleague(Long Colleague) {
        this.Colleague = Colleague;
    }

    public Long getClassmate() {
        return Classmate;
    }
    public void setClassmate(Long Classmate) {
        this.Classmate = Classmate;
    }




}
