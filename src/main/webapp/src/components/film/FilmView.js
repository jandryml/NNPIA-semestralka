import FilmListItem from "./FilmListItem";
import GenericView from "../reusables/GenericView";

const FilmView = () => {
    return (
        <GenericView title="All Films" ListItem={FilmListItem} url={'http://localhost:8080/api/film'}/>
    );
};

export default FilmView;
