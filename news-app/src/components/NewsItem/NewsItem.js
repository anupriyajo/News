import React, { Component } from 'react';
import './style.scss';
import Rating from '../Rating';

export default class NewsItem extends Component {
  render() {
    const { news  } = this.props;
    return (
      <div className="list-item-wrapper">
        <img src={news.mediaContent} />
        <a href={news.link} target="_blank"><h3>{news.title}</h3></a>
        <h6>{news.author} (published on: {news.publishedDate})</h6>
        <div className="list-item">{news.description}</div>
        <Rating itemId={news.newsItemId}/>
      </div>
    )
  }
}