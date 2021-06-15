import CinemaListItem from "./CinemaListItem";
import GenericList from "../reusables/GenericList";

const CinemaView = () => {
    return (
        <GenericList title="All Cinemas" ListItem={CinemaListItem} url={'http://localhost:8080/api/cinema'}/>
    );
};

export default CinemaView;
