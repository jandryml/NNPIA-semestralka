const GenericList = ({items, title, ListItem}) => {
    return (
        <div className="blog-list">
            <h2>{title}</h2>
            {items.map((item) => (
                <ListItem item={item}/>
            ))}
        </div>
    );
};

export default GenericList;