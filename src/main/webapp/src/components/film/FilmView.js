import FilmListItem from "./FilmListItem";
import GenericList from "../reusables/GenericList";

const FilmView = () => {
    return (
        <GenericList title="All Films" ListItem={FilmListItem} url={'http://localhost:8080/api/film'}/>
    );
};

export default FilmView;
