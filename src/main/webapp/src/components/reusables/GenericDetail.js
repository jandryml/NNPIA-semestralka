import {useHistory, useParams} from "react-router";
import useFetch from "../../hooks/useFetch";
import {useState} from "react";

const GenericDetail = ({DetailLayout, AdditionalLayout, DetailForm, handleDelete, url}) => {
        const {id} = useParams();
        const history = useHistory()
        const {data, error, isPending} = useFetch(url + id);
        const [isEditMode, setIsEditMode] = useState(false)

        const handleToggleEdit = () => {
            setIsEditMode(current => !current)
        };

        const goBack = () => {
            history.go(-1)
        };

        return (
            <div className="blog-details">
                {isPending && <div>Loading...</div>}
                {error && <div>{error}</div>}
                {data &&
                <article>
                    {isEditMode ? (<DetailForm input={data}/>) : (<DetailLayout item={data}/>)}
                    <button className="example-custom-input" onClick={handleToggleEdit}>modify</button>
                    <button className="example-custom-input" onClick={handleDelete}>delete</button>
                    <button className="example-custom-input" onClick={goBack}>back</button>
                </article>
                }
                {data && AdditionalLayout && <AdditionalLayout parent={data}/>}
            </div>
        );
    }
;

export default GenericDetail;