import useFetch from "../../services/useFetch";
import GenericList from "../reusables/GenericList";

const GenericView = ({url, title, ListItem}) => {
    const {data, isPending, error} = useFetch(url);

    return (
        <div className="home">
            {error && <div>{error}</div>}
            {isPending && <div>Loading...</div>}
            {data && <GenericList items={data} title={title} ListItem={ListItem}/>}
        </div>
    );
};

export default GenericView;
