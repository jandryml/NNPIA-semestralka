const GenericList = ({items, title, ListItem}) => {
    return (
        <div className="blog-list">
            <h2>{title}</h2>
            {items.map((item) => (
                <ListItem item={item} key={item.id}/>
            ))}
        </div>
    );
};

export default GenericList;