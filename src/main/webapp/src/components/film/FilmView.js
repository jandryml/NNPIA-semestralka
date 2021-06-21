import FilmListItem from "./FilmListItem";
import GenericList from "../reusables/GenericList";
import {useHistory} from "react-router";
import useRoles from "../../hooks/useRoles";

const FilmView = () => {
    const history = useHistory();
    const {isAdmin} = useRoles();

    function handleClick() {
        history.push("/film/add");
    }

    return (
        <div>
            <GenericList title="All Films" ListItem={FilmListItem} url={'http://localhost:8080/api/film'}/>
            {isAdmin && <button onClick={handleClick}>Add film</button>}
        </div>
    );
};

export default FilmView;
