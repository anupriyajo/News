import React, { Component } from 'react';
import NewsItem from '../../components/NewsItem';
import './style.scss';

export default class NewsList extends Component {
  render() {
    const { newsType, newsItems } = this.props;
    let content = (<div></div>);
    
    if(newsItems) {
      content = newsItems.map((newsItem) =>  (
        <NewsItem key={`item-${newsItem.newsItemId}`} news={newsItem}/>
      ));
    }

    return (
      <div className="list-wrapper">
        <h1>{newsType}</h1>
        {content}
      </div>
    )
  }
}